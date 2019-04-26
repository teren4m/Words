package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import androidx.lifecycle.LiveData
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.MapCircle
import com.google.android.gms.maps.model.LatLng

interface INavigationViewModel {

    val points: LiveData<List<MapCircle>>

    fun getPoints(zoom: Float, min: LatLng, max: LatLng)

}