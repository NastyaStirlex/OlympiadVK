package com.example.servicesvk.data

import com.example.servicesvk.Items
import com.example.servicesvk.Service
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("semi-final-data.json")
    fun getServices(): Call<Items>
}