package com.nna.sklnabi.network

import com.nna.sklnabi.model.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("v1/nabi")
    fun getDataNabi() :Call<List<ResponseItem>>

    @GET("v1/rasul")
    fun getDataRasul() :Call<List<ResponseItem>>
}