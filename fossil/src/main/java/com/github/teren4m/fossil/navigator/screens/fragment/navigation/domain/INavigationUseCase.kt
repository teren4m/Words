package com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.MapCircle
import io.reactivex.Observable

interface INavigationUseCase {

    fun getCollectionsSummary(
        minLocation: Location,
        maxLocation: Location,
        zoom: Float
    ): Observable<MapCircle>

}