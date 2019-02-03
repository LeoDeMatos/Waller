package br.com.leonardo.waller.view

import br.com.leonardo.core.model.Photo

interface WallView {
    fun onPhotosLoaded(photos: MutableList<Photo>)
}
