package br.com.leonardo.waller.model.dataManager

import android.content.Context
import br.com.leonardo.waller.Preferences
import br.com.leonardo.core.model.Photo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Leonardo on 26/11/17.
 *
 * All rights reserved.
 */
class WLRPhotosDataManager{

    fun fetchFavorites(context: Context?): MutableList<Photo>{
        val rawJsonData = Preferences.getSharedPreference(context,Preferences.FAVORITES_BUCKET)

        val listType = object : TypeToken<MutableList<Photo>>() {
        }.type

        return Gson().fromJson(rawJsonData, listType) ?: mutableListOf()
    }

    fun addPhotoToFavorites(context: Context, photo: Photo) {
        val data = Preferences.getSharedPreference(context, Preferences.FAVORITES_BUCKET)
        var favorites = mutableListOf<Photo>()
        if (!data.isNullOrEmpty()) {
            val listType = object : TypeToken<MutableList<Photo>>() {
            }.type
            favorites = Gson().fromJson<MutableList<Photo>>(data, listType)
            favorites.add(photo)
        } else {
            favorites = mutableListOf(photo)
        }
        Preferences.saveSharedPreference(context, Preferences.FAVORITES_BUCKET, Gson().toJson(favorites))
    }
}