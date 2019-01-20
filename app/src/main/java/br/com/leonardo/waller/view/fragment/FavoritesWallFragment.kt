package br.com.leonardo.waller.view.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import br.com.leonardo.waller.Preferences
import br.com.leonardo.waller.WallAdapter
import br.com.leonardo.waller.model.BaseWallModel
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.presenter.WLRFavoritesPresenter
import br.com.leonardo.waller.presenter.WallPresenter
import br.com.leonardo.waller.presenter.view.WLRFavoritesView
import br.com.leonardo.waller.view.WallView
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.util.*

/**
 * Created by Leonardo on 22/10/17.
 */

class FavoritesWallFragment : BaseFragment(), WLRFavoritesView{

    private lateinit var mList: RecyclerView

    private val presenter: WLRFavoritesPresenter by lazy {
        WLRFavoritesPresenter(context,this@FavoritesWallFragment)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mList = RecyclerView(this@FavoritesWallFragment.context)

        val w = activity.window
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        configureViews()

        return mList
    }

    private fun configureViews(){
        mList.setHasFixedSize(true)
        mList.layoutManager = GridLayoutManager(this@FavoritesWallFragment.context, 2, GridLayoutManager.VERTICAL, false)

        presenter.fetchFavorites()
    }

    override fun onFavoritesReceived() {
        if(mList.adapter == null){
            presenter.favorites?.let {
                val adapter = WallAdapter(it)
                mList.adapter = adapter
            }
        }else {
            mList.adapter.notifyDataSetChanged()
        }
    }
}