package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.util.Calc

class NavigateViewModel : ViewModel() {
    var latitude: MutableLiveData<Double> = MutableLiveData()
    var longitude: MutableLiveData<Double> = MutableLiveData()
    var distance: MediatorLiveData<String> = MediatorLiveData()

    init {
        val observer = Observer<Double> {
            val latitudeNonNull = latitude.value?.toDouble() ?: 0.0
            val longitudeNonNull = latitude.value?.toDouble() ?: 0.0
            distance.value = Calc().directDistance(
                latitudeNonNull,
                longitudeNonNull,
                0.0,
                0.0
            ).toString()
        }
        distance.addSource(latitude, observer)
        distance.addSource(longitude, observer)
    }
}
