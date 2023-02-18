package com.example.servicesvk.data

import com.example.servicesvk.dto.Items
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("semi-final-data.json")
    fun getServices(): Call<Items>
}