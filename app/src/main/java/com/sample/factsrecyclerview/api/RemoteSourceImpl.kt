package com.sample.factsrecyclerview.api

import com.sample.factsrecyclerview.model.Facts
import com.sample.factsrecyclerview.viewmodel.MainViewModel

class RemoteSourceImpl(private val apiInterface: ApiInterface): RemoteSource {
    private var mainViewModel: MainViewModel? = null

    override suspend fun getFacts(): Facts {
        return apiInterface.getFacts()
    }
}