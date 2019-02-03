package br.com.leonardo.waller.presenter

import android.content.Context
import br.com.leonardo.core.model.Photo
import br.com.leonardo.waller.model.dataManager.WLRPhotosDataManager
import br.com.leonardo.waller.presenter.view.WLRFavoritesView

/**
 * Created by Leonardo de Matos on 29/04/17.
 */

class WLRFavoritesPresenter(val context: Context?, private val mView: WLRFavoritesView) {

    private val dataManager: WLRPhotosDataManager = WLRPhotosDataManager()

    var favorites: MutableList<Photo>? = null

    fun fetchFavorites() {
        favorites = dataManager.fetchFavorites(context)
        mView.onFavoritesReceived()
    }
}
