package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.fossil.navigator.core.location.Location
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.INavigationUseCase
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.model.MapCircle
import com.google.android.gms.maps.model.LatLng
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class NavigationViewModel @Inject constructor(
    private val navigationUseCase: INavigationUseCase
) : INavigationViewModel, BaseViewModel() {

    override val points = MutableLiveData<List<MapCircle>>()

    override fun getPoints(zoom: Float, min: LatLng, max: LatLng) {
        navigationUseCase.getCollectionsSummary(
            minLocation = Location(
                min.latitude, min.longitude
            ),
            maxLocation = Location(
                max.latitude, max.longitude
            ),
            zoom = zoom
        )
            .toList()
            .subscribeOnDefaultThread()
            .subscribeBy(
                onSuccess = {
                    points.postValue(it)
                },
                onError = {
                    toString()
                }
            ).addDisposable()
    }

}