package br.com.leonardo.waller.view.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.presenter.WallPresenter
import br.com.leonardo.waller.view.adapter.viewHolder.WallViewHolder

/**
 * Created by Leonardo on 03/09/17.
 */

class UserWallAdapter(private val mPhotos: MutableList<Photo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val PHOTO = 1

    var mWallListener: WallPresenter.WallListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WallViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position != mPhotos.size) {
            val baseWallModel = mPhotos[position]
            if(holder is WallViewHolder) {
                holder.bindUnplashPhoto(baseWallModel)
                holder.mWallListener = mWallListener
            }
            paintBackground(position, holder.itemView.findViewById(R.id.image))

            if (itemCount >= 40 && position >= itemCount - 10) {
                mWallListener?.loadNextPage()
            }
        }
    }


    override fun getItemCount(): Int {
        return if(mPhotos.size % 2 == 0) mPhotos.size else mPhotos.size + 1
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