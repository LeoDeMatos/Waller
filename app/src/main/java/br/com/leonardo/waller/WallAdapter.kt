package br.com.leonardo.waller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.core.model.Photo
import br.com.leonardo.waller.view.adapter.viewHolder.WallViewHolder

/**
 * Created by Leonardo de Matos on 09/04/17.
 */

class WallAdapter(private val mPhotos: MutableList<Photo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WallViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val baseWallModel = mPhotos[position]
        (holder as WallViewHolder).bindUnplashPhoto(baseWallModel)

        paintBackground(position, holder.itemView.findViewById(R.id.image))
    }

    override fun getItemCount(): Int {
        return mPhotos.size
    }

    private fun paintBackground(position: Int, view: View) {
        view.setBackgroundColor(ContextCompat.getColor(view.context, if (position % 5 == 0) R.color.white else R.color.whiteish))
    }

    fun addNewPage(photos: List<Photo>) {
        val start = mPhotos.size - 2
        mPhotos.addAll(photos)
        notifyItemRangeChanged(start, mPhotos.size)
    }
}
