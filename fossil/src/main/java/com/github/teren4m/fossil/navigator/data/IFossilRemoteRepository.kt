package com.github.teren4m.fossil.navigator.data

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.data.model.Cluster
import io.reactivex.Observable

interface IFossilRemoteRepository {

    fun getCollectionsSummary(
        minLocation: Location,
        maxLocation: Location,
        level: Int
    ): Observable<Cluster>

}