package com.example.unsplashapp.data.remote.unsplash

import com.example.unsplashapp.common.Constants
import com.example.unsplashapp.data.remote.entity.GetPhotoDetailResult
import com.example.unsplashapp.data.remote.entity.SearchPhotosResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

//retrofit interface 後にbuilderを使用して実体クラスを作成し、インスタンスを作成する
interface UnsplashApi {

    //@Queryと@Pathの違いは、@QueryはURLの後ろにクエリパラメータを追加するのに対し、@PathはURLの中にパラメータを埋め込む
    //例えば、https://api.unsplash.com/photos/{id}のように{id}の部分に値を埋め込む
    //https://api.unsplash.com/search/photos?query=dogのようにクエリパラメータを追加する

    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query: String): SearchPhotosResult

    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("photos/{id}")
    suspend fun getPhotoDetail(@Path("id") id: String): GetPhotoDetailResult
}