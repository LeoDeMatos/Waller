package br.com.leonardo.waller.presenter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.View
import br.com.leonardo.waller.Preferences
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.model.WallerService
import br.com.leonardo.waller.model.WallerServiceCreator
import br.com.leonardo.waller.view.DetailActivity
import br.com.leonardo.waller.view.WallView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Leonardo de Matos on 29/04/17.
 */

class WallPresenter(val context: Context, private val mView: WallView) {

    private val CLIENT_ID = ""
    private val DRIBBLE_CLIENT_ID = "c76b236856692cc339bf4d2b9f8038f47fdad7194052b0f1bd7fa6617c021ed3"

    private val mUnplashService: WallerService = WallerServiceCreator().create(context, false)
    private val mDribbbleService: WallerService = WallerServiceCreator().create(context, true)

    private var photos: MutableList<Photo>? = null

    private var currentPage = 1
    private var userWallCurrentPage = 1

    fun fetchPhotos(isNext: Boolean) {
        currentPage = if (isNext) currentPage + 1 else currentPage
        mUnplashService
                .photos(CLIENT_ID, currentPage, 40)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( { photo ->
                    currentPage++
                    photos = photo
                    mView.onPhotosLoaded(photos!!)
                },{})
    }

    fun fetchPhotos(url: String, isNext: Boolean) {
        userWallCurrentPage = if (isNext) userWallCurrentPage + 1 else userWallCurrentPage
        mUnplashService
                .photosByUser(url, CLIENT_ID, currentPage, 40)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( { photo ->
                    mView.onPhotosLoaded(photo)
                },{})
    }

    fun addWallListener(): WallListener {
        return object : WallPresenter.WallListener {
            override fun loadNextPage() {
                fetchPhotos(true)
            }

            override fun onPhotoSelected(photo: Photo, animatedView: View) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("urls", Gson().toJson(photo))
                context.startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(context as Activity, animatedView.findViewById<View>(R.id.image),
                                "target").toBundle())

            }

            override fun onPhotoFavorite(photo: Photo) {
                val data = Preferences.getSharedPreference(context,Preferences.FAVORITES_BUCKET)
                var favorites = mutableListOf<Photo>()
                if(!data.isNullOrEmpty()){
                    val listType = object : TypeToken<MutableList<Photo>>() {
                    }.type
                    favorites = Gson().fromJson<MutableList<Photo>>(data, listType)
                    favorites.add(photo)
                }else{
                    favorites = mutableListOf(photo)
                }
                Preferences.saveSharedPreference(context,Preferences.FAVORITES_BUCKET, Gson().toJson(favorites))
            }
        }
    }

    //MARK: List Listener
    interface WallListener {
        fun loadNextPage()
        fun onPhotoSelected(photo: Photo, animatedView: View)
        fun onPhotoFavorite(photo: Photo)
    }

}
