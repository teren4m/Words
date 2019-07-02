package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observeData
import com.github.teren4m.fossil.navigator.R
import com.github.teren4m.fossil.navigator.utils.addCircles
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable

class NavigationFragment : MvvmFragment<INavigationViewModel>(), OnMapReadyCallback {

    override val layoutId = R.layout.fragment_navigation

    private lateinit var rxPermissions: RxPermissions
    private lateinit var disposable: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rxPermissions = RxPermissions(this)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {

        googleMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isMyLocationButtonEnabled = true
        }

        disposable = rxPermissions
            .request(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .subscribe { granted ->
                if (granted) {
                    googleMap.isMyLocationEnabled = true
                }
            }

        viewModel.points.observeData(this) {
            it.let(googleMap::addCircles)
        }

        googleMap.setOnCameraIdleListener {
            googleMap.projection.visibleRegion.also {

                val zoom = googleMap.cameraPosition.zoom
                viewModel.getPoints(
                    zoom = zoom,
                    min = LatLng(it.nearLeft.latitude, it.nearLeft.longitude),
                    max = LatLng(it.farRight.latitude, it.farRight.longitude)
                )

            }
        }
    }
}