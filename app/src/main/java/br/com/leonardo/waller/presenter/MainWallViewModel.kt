package br.com.leonardo.waller.presenter

import android.net.Uri
import br.com.leonardo.core.LMRecyclerViewDataSource
import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.util.Paginator
import br.com.leonardo.core.util.ViewModelState
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.dataManager.UnplashRepository
import br.com.leonardo.waller.util.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Leonardo de Matos on 29/04/17.
 */

class MainWallViewModel : BaseViewModel(), LMRecyclerViewDataSource<MainWallViewModel.WallListItem> {

    sealed class ViewType(val rawViewType: Int) {
        object Header : ViewType(R.layout.row_wall_header)
        object Photo : ViewType(R.layout.row_item)
    }

    data class WallListItem(val viewType: ViewType, val photo: Photo? = null)

    @Inject
    lateinit var unplashRepository: UnplashRepository

    private lateinit var listItems: MutableList<WallListItem>

    private var photos: MutableList<Photo>? = null
    private val paginator = Paginator(0, 20)

    private val disposeBag = CompositeDisposable()

    fun init() {
        fetchPhotos()
        listItems = mutableListOf()
    }

    private fun fetchPhotos() {
        val disposable = unplashRepository.getPhotos(paginator)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ photo ->
                    if (paginator.isLoadingNextPage()) {
                        photos?.addAll(photo)
                        paginator.didLoadNextPage()
                    } else {
                        photos = photo
                    }

                    photos?.forEach {
                        it.urls.parsedResource = Uri.parse(it.urls.regular)
                        listItems.add(WallListItem(ViewType.Photo, it))
                    }
                    postNewState(ViewModelState.Success)

                }, {
                    if (paginator.isLoadingNextPage()) {
                        paginator.didNotLoadNextPage()
                    }
                    postNewState(ViewModelState.Error)
                })

        disposeBag.add(disposable)
    }

    //MARK: - View actions
    fun loadNextPage() {
        paginator.loadNextPage()
        fetchPhotos()
    }

    override fun getItemCount(): Int = listItems.size
    override fun getItemFor(position: Int): WallListItem {
        if (position == (getItemCount() * paginator.getCurrentPage()) - 3) {
            paginator.loadNextPage()
            fetchPhotos()
        }
        return listItems[position]
    }

    override fun getViewTypeFor(position: Int): Int = getItemFor(position).viewType.rawViewType
}
