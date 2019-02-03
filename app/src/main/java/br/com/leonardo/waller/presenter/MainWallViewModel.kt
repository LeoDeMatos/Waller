package br.com.leonardo.waller.presenter

import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.util.Paginator
import br.com.leonardo.core.util.ViewModelState
import br.com.leonardo.waller.model.dataManager.UnplashRepository
import br.com.leonardo.waller.util.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Leonardo de Matos on 29/04/17.
 */

class MainWallViewModel : BaseViewModel() {

    @Inject
    lateinit var unplashRepository: UnplashRepository

    private var photos: MutableList<Photo>? = null
    private val paginator = Paginator(0, 20)

    private val disposeBag = CompositeDisposable()

    fun init() {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        val disposable = unplashRepository.getPhotos(paginator)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ photo ->
                if (paginator.isLoadingNextPage()) {
                    paginator.didLoadNextPage()
                }
                photos = photo
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
}
