package com.github.teren4m.fossil.navigator.utils

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions

fun GoogleMap.addCircles(circle: List<CircleOptions>) {
    clear()
    circle.map(this::addCircle)
}