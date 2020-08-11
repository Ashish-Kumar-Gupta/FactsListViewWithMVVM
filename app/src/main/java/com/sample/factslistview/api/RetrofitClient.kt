package com.sample.factslistview.api

import android.content.Context
import com.sample.factslistview.utils.DOMAIN_URL_KEY
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClient() {
    companion object {
        var retrofit: Retrofit? = null

        fun getRetrofitClient(context: Context): ApiInterface {
            retrofit = Retrofit.Builder()
                .baseUrl(DOMAIN_URL_KEY)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit!!.create(ApiInterface::class.java)
        }
    }
}