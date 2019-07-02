package com.github.teren4m.fossil.navigator.utils

import android.os.Handler
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions

fun GoogleMap.addCircles(circle: List<CircleOptions>) {
    clear()
    val handler = Handler()
    circle.chunked(10)
        .forEach {
            handler.postDelayed(Runnable {
                it.map(this::addCircle)
            }, 5)
        }
}