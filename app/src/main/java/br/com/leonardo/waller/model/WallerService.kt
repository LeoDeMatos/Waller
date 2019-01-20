package br.com.leonardo.waller.model

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import rx.Observable

/*
 * Created by Leonardo de Matos on 06/03/17.
 */
interface WallerService {
    //MARK - USER WS's
    @GET("photos")
    fun photos(@Query("client_id") clientId: String,
               @Query("page") page: Int?,
               @Query("per_page") perPage: Int?): Observable<MutableList<Photo>>


    @GET
    fun photosByUser(@Url url: String, @Query("client_id") clientId: String, @Query("page") page: Int?, @Query("per_page") perPage: Int?): Observable<MutableList<Photo>>


    @GET("shots")
    fun shots(@Query("access_token") token: String, @Query("per_page") perPage: Int?): Observable<MutableList<Shot>>
}