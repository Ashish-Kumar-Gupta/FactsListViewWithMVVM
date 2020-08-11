package com.sample.factslistview.api

import retrofit2.Response

interface ApiResponse<T> {
    fun onResponse(requestCode: Int, response: Response<T>)
    fun onFailure(requestCode: Int, errorMessage: String)
}