package com.github.teren4m.fossil.navigator.data

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.data.model.Record
import io.reactivex.Observable

interface IFossilRemoteRepository {

    fun getCollectionsSummary(
        minLocation: Location,
        maxLocation: Location
    ): Observable<Record>

}