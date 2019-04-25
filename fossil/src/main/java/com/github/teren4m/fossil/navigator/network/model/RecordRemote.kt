package com.github.teren4m.fossil.navigator.network.model

import com.squareup.moshi.Json

class RecordRemote (

    @field:Json(name = "oid")
    val clusterId:String?,

    @field:Json(name = "lv1")
    val clusterLevel1:String?,

    @field:Json(name = "lv2")
    val clusterLevel2: String?,

    @field:Json(name = "lv3")
    val clusterLevel3: String?,

    @field:Json(name = "nco")
    val collectionsNumber:Int?,

    @field:Json(name = "noc")
    val occurrencesNumber: Int?,

    @field:Json(name = "lng")
    val longitude: Double?,

    @field:Json(name = "lat")
    val latitude:Double?,

    @field:Json(name = "lx1")
    val minLongitude: Double?,

    @field:Json(name = "lx2")
    val maxLongitude: Double?,

    @field:Json(name = "ly1")
    val minatitude: Double?,

    @field:Json(name = "ly2")
    val maxLatitude: Double?,

    //The standard deviation of the coordinates in this cluster
    @field:Json(name = "std")
    val standardDeviation: Double?,

    //The identifier of the most specific single interval from the selected timescale that covers the entire time range associated with the collection or cluster.
    @field:Json(name = "cxi")
    val cxi: Int?
)