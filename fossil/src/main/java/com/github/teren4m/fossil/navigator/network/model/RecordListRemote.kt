package com.github.teren4m.fossil.navigator.network.model

import com.squareup.moshi.Json

class RecordListRemote(

    @field:Json(name = "elapsed_time")
    val elapsedTime: Double?,

    @field:Json(name = "records")
    val records: List<RecordRemote>?

)