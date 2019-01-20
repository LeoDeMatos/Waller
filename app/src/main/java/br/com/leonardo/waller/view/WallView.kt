package br.com.leonardo.waller.view

import br.com.leonardo.waller.model.BaseWallModel
import br.com.leonardo.waller.model.Photo

interface WallView {
    fun onPhotosLoaded(photos: MutableList<Photo>)
}
