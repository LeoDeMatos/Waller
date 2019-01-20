package br.com.leonardo.waller.view.adapter.viewHolder

import android.gesture.Gesture
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.presenter.WallPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Leonardo on 03/09/17.
 */
 class WallViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mWallListener: WallPresenter.WallListener? = null

    private var photo: Photo? = null

    init {
        itemView.setOnClickListener { view ->
            photo?.let {
                mWallListener?.onPhotoSelected(it, view)
            }
        }
        itemView.setOnLongClickListener {
            photo?.let {
                mWallListener?.onPhotoFavorite(it)
            }
            true
        }
    }

    fun bindUnplashPhoto(photo: Photo) {
        this.photo = photo
        Glide.with(itemView.context)
                .load(photo.urls.regular)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.findViewById(R.id.image))
    }
}