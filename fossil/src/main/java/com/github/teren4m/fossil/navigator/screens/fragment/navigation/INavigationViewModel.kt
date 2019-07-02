package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import androidx.lifecycle.LiveData
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng

interface INavigationViewModel {

    val points: LiveData<List<CircleOptions>>

    fun getPoints(zoom: Float, min: LatLng, max: LatLng)

}