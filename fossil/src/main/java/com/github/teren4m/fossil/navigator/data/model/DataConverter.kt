package com.github.teren4m.fossil.navigator.data.model

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.network.model.RecordRemote

object DataConverter {

    fun convert(source: RecordRemote): Cluster =
        Cluster(
            id = source.clusterId ?: "",
            location = Location(source.latitude ?: 0.0, source.longitude ?: 0.0),
            border = Location(source.maxLatitude ?: 0.0, source.maxLongitude ?: 0.0)
        )

}