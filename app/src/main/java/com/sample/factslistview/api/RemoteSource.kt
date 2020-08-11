package com.sample.factslistview.api

import com.wipro.factsrecyclerview.model.Facts

interface RemoteSource {
    suspend fun getFacts(): Facts
}