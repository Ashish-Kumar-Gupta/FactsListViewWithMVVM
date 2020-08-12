package com.sample.factsrecyclerview.api

import com.sample.factsrecyclerview.model.Facts

interface RemoteSource {
    suspend fun getFacts(): Facts
}