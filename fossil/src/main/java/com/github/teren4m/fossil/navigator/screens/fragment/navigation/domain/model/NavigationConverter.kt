package com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model

import android.graphics.Color
import com.github.teren4m.fossil.navigator.core.location.ILocationHelper
import com.github.teren4m.fossil.navigator.data.model.Record
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class NavigationConverter @Inject constructor(
    private val locationHelper: ILocationHelper
) {

    fun convert(source: MapCircle): CircleOptions =
        CircleOptions()
            .fillColor(Color.RED)
            .strokeColor(Color.BLUE)
            .strokeWidth(5.0F)
            .radius(source.distantion)
            .center(LatLng(source.latitude, source.longitude))

    fun convert(source: Record): MapCircle =
        MapCircle(
            clusterId = source.id,
            longitude = source.location.longitude,
            latitude = source.location.latitude,
            distantion = locationHelper.distanceInM(source.location, source.border)
        )

}