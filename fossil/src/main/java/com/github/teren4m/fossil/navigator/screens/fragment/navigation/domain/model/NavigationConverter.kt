package com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model

import android.graphics.Color
import com.github.teren4m.fossil.navigator.data.model.Cluster
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class NavigationConverter @Inject constructor(

) {

    fun convert(source: MapCircle): CircleOptions =
        CircleOptions()
            .fillColor(Color.RED)
            .strokeColor(Color.BLUE)
            .strokeWidth(5.0F)
            .radius(source.distantion)
            .center(LatLng(source.latitude, source.longitude))

    fun convert(source: Cluster): MapCircle =
        MapCircle(
            clusterId = source.id,
            longitude = source.location.longitude,
            latitude = source.location.latitude,
            distantion = 200000.0
        )

}