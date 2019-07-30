package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.util.calcDirectDistance
import com.ict.mito.gootravel.util.calcDirection

class NavigateViewModel : ViewModel() {
    var latitude: MutableLiveData<Double> = MutableLiveData()
    var longitude: MutableLiveData<Double> = MutableLiveData()
    var direction: MediatorLiveData<String> = MediatorLiveData()
    var distance: MediatorLiveData<String> = MediatorLiveData()

    init {
        val observer = Observer<Double> {
            direction.postValue(
                calcDirection(
                    latitude.value ?: 0.0,
                    longitude.value ?: 0.0,
                    0.0,
                    0.0
                ).toString()
            )
            distance.postValue(
                calcDirectDistance(
                    latitude.value ?: 0.0,
                    longitude.value ?: 0.0,
                    0.0,
                    0.0
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
