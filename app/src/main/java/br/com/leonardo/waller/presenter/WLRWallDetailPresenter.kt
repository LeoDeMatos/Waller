package br.com.leonardo.waller.presenter

import android.content.Context
import br.com.leonardo.core.model.Photo
import br.com.leonardo.waller.model.dataManager.WLRPhotosDataManager

/**
 * Created by Leonardo on 31/12/17.
 *
 * All rights reserved.
 */
class WLRWallDetailPresenter{

    private val dataManager: WLRPhotosDataManager = WLRPhotosDataManager()

    fun savePhotoToFavorites(context: Context,photo: Photo){
        dataManager.addPhotoToFavorites(context,photo)
    }
}