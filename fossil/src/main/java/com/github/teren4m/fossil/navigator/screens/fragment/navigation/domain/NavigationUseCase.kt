package com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain

import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.data.IFossilRemoteRepository
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.MapCircle
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.NavigationConverter
import io.reactivex.Observable
import javax.inject.Inject

class NavigationUseCase @Inject constructor(
    private val fossilRemoteRepository: IFossilRemoteRepository,
    private val converter: NavigationConverter
) : INavigationUseCase {

    override fun getCollectionsSummary(
        minLocation: Location,
        maxLocation: Location,
        zoom: Float
    ): Observable<MapCircle> =
        fossilRemoteRepository.getCollectionsSummary(
            minLocation,
            maxLocation,
            level = 1
        )
            .map(converter::convert)

}