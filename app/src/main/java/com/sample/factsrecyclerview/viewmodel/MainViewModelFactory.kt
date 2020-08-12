package com.sample.factsrecyclerview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.factsrecyclerview.api.ApiInterface
import com.sample.factsrecyclerview.api.RemoteSourceImpl

class MainViewModelFactory(private val apiInterface: ApiInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(RemoteSourceImpl(apiInterface)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}