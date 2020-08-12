package com.sample.factsrecyclerview.api

import com.sample.factsrecyclerview.utils.DOMAIN_URL_KEY
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClient() {
    companion object {
        private var retrofit: Retrofit? = null

        fun getRetrofitClient(): ApiInterface {
            retrofit = Retrofit.Builder()
                .baseUrl(DOMAIN_URL_KEY)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit!!.create(ApiInterface::class.java)
        }
    }
}