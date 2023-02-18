package com.example.servicesvk

interface GetServicesCallback<T> {
    fun onSuccess(
        services: Items
    )

    fun onError(error: String?)
}