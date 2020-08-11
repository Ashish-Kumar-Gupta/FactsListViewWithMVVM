package com.sample.factslistview.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager<T>(val apiResponse: ApiResponse<T>) {

    fun makeRequest(call: Call<T>, requestCode: Int) {
        call.enqueue(object: Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                apiResponse.onResponse(requestCode, response)
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                apiResponse.onFailure(requestCode, throwable.message.toString())
            }
        })
    }
}