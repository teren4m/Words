package com.github.teren4m.fossil.navigator.data

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.data.model.Record
import com.github.teren4m.fossil.navigator.data.model.DataConverter
import com.github.teren4m.fossil.navigator.network.FossilNetworkDataSource
import io.reactivex.Observable
import javax.inject.Inject

class FossilRemoteRepository @Inject constructor(
    private val fossilNetworkDataSource: FossilNetworkDataSource
) : IFossilRemoteRepository {

    override fun getCollectionsSummary(
        minLocation: Location,
        maxLocation: Location
    ): Observable<Record> =
        fossilNetworkDataSource.getCollections(
            minLocation.longitude,
            maxLocation.longitude,
            minLocation.latitude,
            maxLocation.latitude
        )
            .toObservable()
            .flatMapIterable {
                it.records
            }
            .map(DataConverter::convert)

}