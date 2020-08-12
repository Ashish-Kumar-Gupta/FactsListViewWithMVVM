package com.sample.factsrecyclerview.model

import com.squareup.moshi.Json

data class Fact(
    @Json(name = "title") val title: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "imageHref") val imageHref: String? = null
)