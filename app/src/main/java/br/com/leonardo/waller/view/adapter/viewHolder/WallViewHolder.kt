package br.com.leonardo.waller.view.adapter.viewHolder

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.leonardo.core.model.Photo
import com.facebook.imagepipeline.request.ImageRequestBuilder
import kotlinx.android.synthetic.main.row_item.view.*

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
        itemView.scaleX = 1f
        itemView.scaleY = 1f

        this.photo = photo

        val imageRequest =
                ImageRequestBuilder.newBuilderWithSource(Uri.parse(photo.urls.regular))
                        .build();
        itemView.image.setImageRequest(imageRequest);

//        val requestOptions = RequestOptions().apply {
//            transforms(CenterCrop(), RoundedCorners(15))
//        }

//        Glide.with(itemView.context)
//                .load(photo.urls.regular)
//                .apply(requestOptions)
//                .into(itemView.findViewById(R.id.image))
    }

    fun changeHeight(newHeight: Float) {
        val params = itemView.mainPhotoContainer.layoutParams as StaggeredGridLayoutManager.LayoutParams
        params.height = newHeight.toInt()
        itemView.mainPhotoContainer.layoutParams = params

    }
}