package br.com.leonardo.waller

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.leonardo.core.base.BaseAdapter
import br.com.leonardo.core.util.DensityConverter
import br.com.leonardo.waller.presenter.MainWallViewModel
import br.com.leonardo.waller.view.adapter.viewHolder.WallHeaderViewHolder
import br.com.leonardo.waller.view.adapter.viewHolder.WallViewHolder

/**
 * Created by Leonardo de Matos on 09/04/17.
 */

class WallAdapter : BaseAdapter<MainWallViewModel.WallListItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        initInflater(parent.context)

        return when (viewType) {
            MainWallViewModel.ViewType.Header.rawViewType -> {
                return WallHeaderViewHolder(inflater.inflate(R.layout.row_wall_header, parent, false))
            }
            else -> {
                WallViewHolder(inflater.inflate(R.layout.row_item, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataSource.getItemFor(position)
        when (item.viewType) {
            MainWallViewModel.ViewType.Header -> {
                val params = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                params.isFullSpan = true
                holder.itemView.layoutParams = params

            }
            else -> {
                val photo = item.photo

                val height = photo?.height ?: 0L
                val workingHeight = height * 0.30f
                val workingDpHeight = DensityConverter.toDp(holder.itemView.context, workingHeight)

                Log.i("View Height", "View height for $position is $workingDpHeight")
                (holder as WallViewHolder).changeHeight(workingDpHeight)

                photo?.let { safePhoto ->
                    (holder as WallViewHolder).bindUnplashPhoto(safePhoto)
                }
            }
        }
    }
}
