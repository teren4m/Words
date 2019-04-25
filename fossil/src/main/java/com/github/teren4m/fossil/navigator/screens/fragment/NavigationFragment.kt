package com.github.teren4m.fossil.navigator.screens.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observeOnMain
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.fossil.navigator.R
import com.github.teren4m.fossil.navigator.network.FossilDataSource
import com.github.teren4m.fossil.navigator.network.model.GeographicCollectionSummaryRemote
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class NavigationFragment : MvvmFragment<INavigationViewModel>(), OnMapReadyCallback {

    override val layoutId = R.layout.fragment_navigation

    private lateinit var mMap: GoogleMap
    private lateinit var rxPermissions: RxPermissions
    private lateinit var disposable: Disposable

    @Inject
    lateinit var fossilDataSource: FossilDataSource

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rxPermissions = RxPermissions(this)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        disposable = rxPermissions
            .request(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .subscribe { granted ->
                if (granted) {
                    mMap.isMyLocationEnabled = true
                }
            }

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isMyLocationButtonEnabled = true
        }

        mMap.setOnCameraIdleListener {
            mMap.projection.visibleRegion.also {

                val zoom = mMap.cameraPosition.zoom
                val currZoom = when {
                    zoom < 5.0 -> 1
                    zoom < 8.0 -> 2
                    else -> 3
                }

                fossilDataSource.getCollectionsSummary(
                    longitudeMax = it.farRight.longitude,
                    latitudeMax = it.farRight.latitude,
                    longitudeMin = it.nearLeft.longitude,
                    latitudeMin = it.nearLeft.latitude,
                    level = currZoom
                )
                    .observeOnMain()
                    .subscribeOnDefaultThread()
                    .subscribeBy(
                        onSuccess = ::drawClusters,
                        onError = {
                            toString()
                        }
                    )

//                mMap.addCircle(
//                    CircleOptions().apply {
//                        center(LatLng(0.0, 0.0))
//                        radius(200000.0)
//                        strokeWidth(10.0F)
//                        strokeColor(Color.BLACK)
//                    }
//                )
//
//                mMap.addCircle(
//                    CircleOptions().apply {
//                        center(LatLng(15.0, 15.0))
//                        radius(200000.0)
//                        strokeWidth(10.0F)
//                        strokeColor(Color.WHITE)
//                    }
//                )

            }
        }
    }

    private fun drawClusters(summary: GeographicCollectionSummaryRemote) {

        summary.records?.map {
            val latitude = it.latitude!!
            val longitude = it.longitude!!

            MarkerOptions().apply {
                position(LatLng(latitude, longitude))
            }
        }
            ?.let {
                mMap.clear()
                it.forEach { marker ->
                    mMap.addMarker(marker)
                }
            }
    }
}