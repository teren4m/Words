package com.github.teren4m.fossil.navigator.network.model

import com.squareup.moshi.Json

class GeographicCollectionSummary(

    @Json(name = "elapsed_time")
    val elapsedTime: Double,

    @Json(name = "records")
    val records: List<Any>

)