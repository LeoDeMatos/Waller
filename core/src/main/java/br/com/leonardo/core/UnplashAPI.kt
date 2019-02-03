package br.com.leonardo.core

import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.model.Shot
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/*
 * Created by Leonardo de Matos on 06/03/17.
 */
interface UnplashAPI {
    //MARK - USER WS's
    @GET("photos")
    fun photos(@Query("client_id") clientId: String = BuildConfig.UnplashAPIKey,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?): Single<MutableList<Photo>>

    @GET
    fun photosByUser(@Url url: String, @Query("client_id") clientId: String, @Query("page") page: Int?, @Query("per_page") perPage: Int?): Observable<MutableList<Photo>>

    @GET("shots")
    fun shots(@Query("access_token") token: String, @Query("per_page") perPage: Int?): Observable<MutableList<Shot>>
}