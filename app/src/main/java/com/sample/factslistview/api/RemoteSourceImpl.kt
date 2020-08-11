package com.sample.factslistview.api

class RemoteSourceImpl(private val apiInterface: ApiInterface): RemoteSource {
    override suspend fun getFacts() = apiInterface.getFacts()
}