package br.com.leonardo.waller

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.model.Shot
import br.com.leonardo.waller.presenter.WallPresenter
import br.com.leonardo.waller.view.adapter.viewHolder.WallViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson


/**
 * Created by Leonardo de Matos on 09/04/17.
 */

class WallAdapter(private val mPhotos: MutableList<Photo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mWallListener: WallPresenter.WallListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder =  WallViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
        viewHolder.mWallListener = mWallListener
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val baseWallModel = mPhotos[position]
        (holder as WallViewHolder).bindUnplashPhoto(baseWallModel)

        paintBackground(position, holder.itemView.findViewById(R.id.image))

        if (position == itemCount - 10) {
            mWallListener?.loadNextPage()
        }
    }


    override fun getItemCount(): Int {
        return mPhotos.size
    }

    private fun paintBackground(position: Int, view: View) {
        view.setBackgroundColor(ContextCompat.getColor(view.context, if (position % 5 == 0) R.color.black else R.color.blackish))
    }

    fun addNewPage(photos: List<Photo>) {
        val start = mPhotos.size - 2
        mPhotos.addAll(photos)
        notifyItemRangeChanged(start, mPhotos.size)
    }
}
