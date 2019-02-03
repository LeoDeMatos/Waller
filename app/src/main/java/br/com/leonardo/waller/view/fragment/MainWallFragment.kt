package br.com.leonardo.waller.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.util.ViewModelState
import br.com.leonardo.waller.Preferences
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.BaseWallModel
import br.com.leonardo.waller.presenter.MainWallViewModel
import br.com.leonardo.waller.view.WallView
import com.google.gson.Gson

/**
 * Created by Leonardo on 22/10/17.
 */

class MainWallFragment : BaseFragment(), WallView {

    private lateinit var viewModel: MainWallViewModel

    // MARK: - View Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val w = activity?.window
        w?.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        return inflater.inflate(R.layout.fragment_main_wall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
        configureViewModel()
        bindView()
    }

    // MARK: - View configuration

    override fun configureView() {
//        mSwipeRefresh.setColorSchemeColors(ContextCompat.getColor(this@MainWallFragment.context!!, R.color.colorAccent))
//
//        mSwipeRefresh.isRefreshing = true
//
//        mSwipeRefresh.addView(mList)
//
//        mList.setHasFixedSize(true)
//        mList.layoutManager = GridLayoutManager(this@MainWallFragment.context, 2, GridLayoutManager.VERTICAL, false)
    }

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainWallViewModel::class.java)
        viewModel.register(this, Observer { newState ->
            when (newState) {
                ViewModelState.Success -> {
//                    mSwipeRefresh.isRefreshing = false
//                    mList.adapter?.notifyDataSetChanged()
                }
            }
        })

        viewModel.init()
    }

    override fun bindView() {
    }

    //MARK: Persistence
    private fun savePhotos(photos: List<BaseWallModel>) {
        Preferences.saveSharedPreference(this@MainWallFragment.context, Preferences.RANDOM_BUCKET, Gson().toJson(photos))
    }

    //MARK: View Delegate
    override fun onPhotosLoaded(photos: MutableList<Photo>) {
//        mSwipeRefresh.isRefreshing = false
//        savePhotos(photos = photos)

//        mList.let {
//            if (it.adapter == null) {
//                val adapter = WallAdapter(photos)
////                adapter.mMainWallListener = mWallPresenter?.addWallListener()
//                it.adapter = adapter
//            } else {
//                (it.adapter as WallAdapter).addNewPage(photos)
//            }
//        }
    }
}