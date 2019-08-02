package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.OrientationLiveData
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.util.calcDirectDistance
import com.ict.mito.gootravel.util.calcDirection

class NavigateViewModel(
    val orientationLiveData: OrientationLiveData,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    var latitude: MutableLiveData<Double> = MutableLiveData()
    var longitude: MutableLiveData<Double> = MutableLiveData()
    var azimuth: MutableLiveData<Double> = MediatorLiveData()
    var direction: MediatorLiveData<String> = MediatorLiveData()
    var distance: MediatorLiveData<String> = MediatorLiveData()

    lateinit var spotData: SpotData

    init {
        val observer = Observer<Double> {
            direction.postValue(
                (calcDirection(
                    latitude.value ?: 0.0,
                    longitude.value ?: 0.0,
                    spotData.latitude,
                    spotData.longitude
                ) - (azimuth.value ?: 0.0)).toString()
            )
            distance.postValue(
                calcDirectDistance(
                    latitude.value ?: 0.0,
                    longitude.value ?: 0.0,
                    spotData.latitude,
                    spotData.longitude
                ).toString()
            )
        }
        direction.apply {
            addSource(
                latitude,
                observer
            )
            addSource(
                longitude,
                observer
            )
            addSource(
                azimuth,
                observer
            )
        }

        distance.apply {
            addSource(
                latitude,
                observer
            )
            addSource(
                longitude,
                observer
            )
        }
    }
}
