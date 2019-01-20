package br.com.leonardo.waller.presenter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.View
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.model.WallerService
import br.com.leonardo.waller.model.WallerServiceCreator
import br.com.leonardo.waller.model.dataManager.WLRPhotosDataManager
import br.com.leonardo.waller.presenter.view.WLRFavoritesView
import br.com.leonardo.waller.view.DetailActivity
import br.com.leonardo.waller.view.WallView
import com.google.gson.Gson
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Leonardo de Matos on 29/04/17.
 */

class WLRFavoritesPresenter(val context: Context, private val mView: WLRFavoritesView) {

    private val dataManager: WLRPhotosDataManager = WLRPhotosDataManager()

    var favorites: MutableList<Photo>? = null

    fun fetchFavorites() {
        favorites = dataManager.fetchFavorites(context)
        mView.onFavoritesReceived()
    }
}
