package com.github.teren4m.fossil.navigator.core.location

import javax.inject.Inject

class LocationHelper @Inject constructor(

) : ILocationHelper {

    companion object {
        val EQUATORIAL_EARTH_RADIUS = 6378.1370
        val D2R = Math.PI / 180.0
    }

    override fun distanceInM(location1: Location, location2: Location): Double {
        return 1000.0 * distanceInKM(location1.latitude, location1.longitude, location2.latitude, location2.longitude)
    }

    override fun distanceInKM(location1: Location, location2: Location): Double =
        distanceInKM(location1.latitude, location1.longitude, location2.latitude, location2.longitude)

    private fun distanceInKM(lat1: Double, long1: Double, lat2: Double, long2: Double): Double {
        val dlong = (long2 - long1) * D2R
        val dlat = (lat2 - lat1) * D2R
        val a = Math.pow(Math.sin(dlat / 2.0), 2.0) + (Math.cos(lat1 * D2R) * Math.cos(lat2 * D2R)
                * Math.pow(Math.sin(dlong / 2.0), 2.0))
        val c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a))

        return EQUATORIAL_EARTH_RADIUS * c
    }

}