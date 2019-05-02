package com.github.teren4m.fossil.navigator.data.model

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.network.model.RecordRemote

object DataConverter {

    fun convert(source: RecordRemote): Record =
        Record(
            id = source.id ?: "",
            location = Location(source.latitude ?: 0.0, source.longitude ?: 0.0),
            border = Location(source.minatitude ?: 0.0, source.minLongitude ?: 0.0)
        )

}