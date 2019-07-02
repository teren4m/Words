package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.mvvm.ListLiveData
import com.github.teren4m.base.setupAndSubscribe
import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.performance.Performance
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.INavigationUseCase
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.NavigationConverter
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.jakewharton.rxrelay2.PublishRelay
import javax.inject.Inject

class NavigationViewModel @Inject constructor(
    private val navigationUseCase: INavigationUseCase,
    private val converter: NavigationConverter
) : INavigationViewModel, BaseViewModel() {

    override val points = ListLiveData<CircleOptions>(1000)
    private val pointsRelay = PublishRelay.create<Points>()

    init {
        pointsRelay
            .flatMap {
                navigationUseCase.getCollections(
                    minLocation = Location(
                        it.min.latitude, it.min.longitude
                    ),
                    maxLocation = Location(
                        it.max.latitude, it.max.longitude
                    )
                )
            }
            .map(converter::convert)
            .buffer(10000)
            .setupAndSubscribe(
                onNext = {
                    points.add(it)
                    Performance.endPoints()
                },
                onError = {
                    toString()
                }
            ).addDisposable()
    }

    override fun getPoints(zoom: Float, min: LatLng, max: LatLng) {
        points.clear()
        Performance.startPoints()
        pointsRelay.accept(
            Points(zoom, min, max)
        )
    }

    private class Points(
        val zoom: Float,
        val min: LatLng,
        val max: LatLng
    )

}