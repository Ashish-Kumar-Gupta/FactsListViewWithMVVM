package com.sample.factsrecyclerview.model

import com.squareup.moshi.Json

data class Facts(
    @Json(name = "title") val title: String,
    @Json(name = "rows") val rows: List<Fact>
)