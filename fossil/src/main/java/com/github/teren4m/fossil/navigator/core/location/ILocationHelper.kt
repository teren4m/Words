package com.github.teren4m.fossil.navigator.core.location

interface ILocationHelper {

    fun distanceInKM(location1: Location, location2: Location): Double

    fun distanceInM(location1: Location, location2: Location): Double

}