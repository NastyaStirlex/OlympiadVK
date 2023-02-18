package com.example.servicesvk

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _servicesData = mutableStateOf(Items(emptyList()))
    val servicesData: State<Items>
        get() = _servicesData

    fun getServices() = viewModelScope.launch {
        repository.getServices(
            object: GetServicesCallback<Items> {
                override fun onSuccess(services: Items) {
                    _servicesData.value = services
                    Log.d("ServicesData", _servicesData.value.items[0].description)
                }

                override fun onError(error: String?) {}

            }
        )
    }
}