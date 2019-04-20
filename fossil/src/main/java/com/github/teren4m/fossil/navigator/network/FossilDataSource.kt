package com.github.teren4m.fossil.navigator.network

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.kittinunf.fuel.rx.rxObject
import com.github.kittinunf.result.Result
import com.github.teren4m.fossil.navigator.network.model.GeographicCollectionSummary
import io.reactivex.Single
import javax.inject.Inject

class FossilDataSource
@Inject constructor() {

    fun getCollectionsSummary(): Single<Result<GeographicCollectionSummary, FuelError>> =
        "https://paleobiodb.org/data1.2/colls/summary.json?lngmin=0.0&lngmax=15.0&latmin=0.0&latmax=15.0&level=2&show=bin,ext,time"
            .httpGet()
            .rxObject(moshiDeserializerOf(GeographicCollectionSummary::class.java))

}