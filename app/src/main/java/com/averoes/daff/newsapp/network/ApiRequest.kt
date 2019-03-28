package com.averoes.daff.newsapp.network

import com.averoes.daff.newsapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by daff on 28/03/19 at 7:53.
 */

//todo 4 buat class baru untuk request ke server
interface ApiRequest {

    //todo 5 panggil request methode untuk meminta data yang mau ditamplikan
    //@REQUEST_METHODE("endpoints/data yang kita minta")
    @GET("v2/top-headlines?country=id&apiKey=b2756b165db84905923d652c88a44445")
    //todo 6 buat function untuk menerima response dari database
    fun getDataServer(): Call<ResponseNews>
}