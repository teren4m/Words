package com.github.teren4m.fossil.navigator.network

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.kittinunf.fuel.rx.rxResponseObject
import com.github.teren4m.fossil.navigator.network.model.GeographicCollectionSummaryRemote
import io.reactivex.Single
import javax.inject.Inject

class FossilDataSource
@Inject constructor() {

    fun getCollectionsSummary(
        longitudeMin: Double,
        longitudeMax: Double,
        latitudeMin: Double,
        latitudeMax: Double,
        level: Int
    ): Single<GeographicCollectionSummaryRemote> =
        "https://paleobiodb.org/data1.2/colls/summary.json?lngmin=$longitudeMin&lngmax=$longitudeMax&latmin=$latitudeMin&latmax=$latitudeMax&level=$level&show=bin,ext,time"
            .httpGet()
            .rxResponseObject(moshiDeserializerOf(GeographicCollectionSummaryRemote::class.java))

}