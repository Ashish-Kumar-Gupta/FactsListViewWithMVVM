package com.sample.factsrecyclerview.api

import com.sample.factsrecyclerview.model.Facts
import com.sample.factsrecyclerview.utils.*
import retrofit2.http.GET

interface ApiInterface {
    @GET(BASE_URL_KEY + GET_FACTS_KEY)
    suspend fun getFacts(): Facts
}