package com.github.teren4m.fossil.navigator.network.model

import com.squareup.moshi.Json

class GeographicCollectionSummaryRemote(

    @field:Json(name = "elapsed_time")
    val elapsedTime: Double?,

    @field:Json(name = "records")
    val records: List<RecordRemote>?

)