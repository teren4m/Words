package com.github.teren4m.fossil.navigator.performance

import android.util.Log

object Performance {

    private var pointsTime: Long = 0

    fun startPoints() {
        pointsTime = System.currentTimeMillis()
    }

    fun endPoints() {
        Log.i("PerformancePointsTime", "Points time: ${System.currentTimeMillis() - pointsTime}")
    }

    fun endPointsNetwork() {
        Log.i("PerformancePointsTime", "Network time: ${System.currentTimeMillis() - pointsTime}")
    }

}