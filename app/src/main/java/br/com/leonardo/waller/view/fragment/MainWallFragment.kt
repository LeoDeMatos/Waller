package br.com.leonardo.waller.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import br.com.leonardo.waller.Preferences
import br.com.leonardo.waller.R
import br.com.leonardo.waller.WallAdapter
import br.com.leonardo.waller.model.BaseWallModel
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.presenter.WallPresenter
import br.com.leonardo.waller.view.WallView
import com.google.gson.Gson

/**
 * Created by Leonardo on 22/10/17.
 */

class MainWallFragment: BaseFragment(), WallView {

    private lateinit var mList: RecyclerView
    private lateinit var mSwipeRefresh: SwipeRefreshLayout
    private lateinit var mWallPresenter: WallPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val w = activity.window
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        configureViews()

        mWallPresenter = WallPresenter(this@MainWallFragment.context, this)
        mWallPresenter.fetchPhotos(false)

        return mSwipeRefresh
    }

    private fun configureViews(){
        mList = RecyclerView(this@MainWallFragment.context)
        mSwipeRefresh = SwipeRefreshLayout(this@MainWallFragment.context)
        mSwipeRefresh.setColorSchemeColors(ContextCompat.getColor(this@MainWallFragment.context, R.color.colorAccent))

        mSwipeRefresh.isRefreshing = true

        mSwipeRefresh.addView(mList)

        mList.setHasFixedSize(true)
        mList.layoutManager = GridLayoutManager(this@MainWallFragment.context, 2, GridLayoutManager.VERTICAL, false)
    }

    //MARK: Persistence
    private fun savePhotos(photos: List<BaseWallModel>) {
        Preferences.saveSharedPreference(this@MainWallFragment.context, Preferences.RANDOM_BUCKET, Gson().toJson(photos))
    }

    //MARK: View Delegate
    override fun onPhotosLoaded(photos: MutableList<Photo>) {
        mSwipeRefresh.isRefreshing = false
        savePhotos(photos = photos)

        mList.let {
            if (it.adapter == null) {
                val adapter = WallAdapter(photos)
                adapter.mWallListener = mWallPresenter?.addWallListener()
                it.adapter = adapter

            } else {
                (it.adapter as WallAdapter).addNewPage(photos)
            }
        }
    }
}