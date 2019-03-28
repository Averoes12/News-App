package com.averoes.daff.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by daff on 28/03/19 at 7:50.
 */

//todo 1 buat class baru didalam package network untuk configurasi network

class ConfigRetrofit {

    //todo 2 configurasi retrofit
    fun initRetrofit(): Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    //todo 6 masukkan configurasi retrofit ke dalam request
    fun getRequest(): ApiRequest {

        val request = initRetrofit().create(ApiRequest::class.java)
        return request
    }
}