package com.example.servicesvk

import com.example.servicesvk.dto.Items

interface GetServicesCallback<T> {
    fun onSuccess(
        services: Items
    )

    fun onError(error: String?)
}