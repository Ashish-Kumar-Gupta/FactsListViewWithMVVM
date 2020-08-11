package com.sample.factslistview.api

import com.sample.factslistview.utils.*
import com.wipro.factsrecyclerview.model.Facts
import retrofit2.http.GET

interface ApiInterface {
    @GET(BASE_URL_KEY + GET_FACTS_KEY)
    fun getFacts(): Facts
}