package br.com.leonardo.waller.view.adapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.core.model.Photo
import br.com.leonardo.waller.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Leonardo on 03/09/17.
 */
 class WallViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var photo: Photo? = null

    init {
        itemView.setOnClickListener { view ->
            photo?.let {
            }
        }
        itemView.setOnLongClickListener {
            photo?.let {

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