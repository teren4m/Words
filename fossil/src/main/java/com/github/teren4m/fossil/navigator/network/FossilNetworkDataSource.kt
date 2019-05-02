package com.github.teren4m.fossil.navigator.network

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.kittinunf.fuel.rx.rxResponseObject
import com.github.teren4m.fossil.navigator.network.model.RecordListRemote
import io.reactivex.Single
import javax.inject.Inject

class FossilNetworkDataSource
@Inject constructor() {

    companion object {
        const val BASE_URL = "https://paleobiodb.org/data1.2/"
    }

    fun getCollectionsSummary(
        longitudeMin: Double,
        longitudeMax: Double,
        latitudeMin: Double,
        latitudeMax: Double,
        level: Int
    ): Single<RecordListRemote> =
        "${BASE_URL}colls/summary.json?lngmin=$longitudeMin&lngmax=$longitudeMax&latmin=$latitudeMin&latmax=$latitudeMax&level=$level&show=bin,ext,time"
            .httpGet()
            .rxResponseObject(
                moshiDeserializerOf(
                    RecordListRemote::class.java
                )
            )

    fun getCollections(
        longitudeMin: Double,
        longitudeMax: Double,
        latitudeMin: Double,
        latitudeMax: Double
    ): Single<RecordListRemote> =
        "${BASE_URL}colls/list.json?lngmin=$longitudeMin&lngmax=$longitudeMax&latmin=$latitudeMin&latmax=$latitudeMax&show=full"
            .httpGet()
            .rxResponseObject(
                moshiDeserializerOf(
                    RecordListRemote::class.java
                )
            )
            .map {
                it
            }
            .doOnError {
                toString()
            }

}