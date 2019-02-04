package br.com.leonardo.waller.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.waller.presenter.WLRFavoritesPresenter
import br.com.leonardo.waller.presenter.view.WLRFavoritesView

/**
 * Created by Leonardo on 22/10/17.
 */

class FavoritesWallFragment : BaseFragment(), WLRFavoritesView{
    override fun configureViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configureView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mList: RecyclerView

    private val presenter: WLRFavoritesPresenter by lazy {
        WLRFavoritesPresenter(context,this@FavoritesWallFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mList = RecyclerView(this@FavoritesWallFragment.context!!)

        val w = activity?.window
        w?.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

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
//                val adapter = WallAdapter(it)
//                mList.adapter = adapter
            }
        }else {
            mList.adapter?.notifyDataSetChanged()
        }
    }
}