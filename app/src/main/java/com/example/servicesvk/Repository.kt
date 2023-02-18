package com.example.servicesvk

import com.example.servicesvk.data.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    private var callGetServices: Call<Items>? = null

    fun getServices(callback: GetServicesCallback<Items>) {
        callGetServices = apiService.getServices()
        callGetServices!!.enqueue(
            object: Callback<Items> {
                override fun onResponse(
                    call: Call<Items>,
                    response: Response<Items>
                ) {
                    response.body()?.let {
                        it -> if(response.isSuccessful) {
                            callback.onSuccess(
                                services = it
                            )
                    } else {
                        try {
                            val errorBody = response.errorBody()
                            callback.onError(error = errorBody.toString())
                        } catch (e: Exception) {
                            throw e
                        }
                    }
                    }
                }

                override fun onFailure(call: Call<Items>, t: Throwable) {
                    callback.onError(t.message)
                }

            }
        )
    }
}