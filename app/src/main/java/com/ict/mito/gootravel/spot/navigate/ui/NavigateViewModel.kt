package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigateViewModel : ViewModel() {
    var latitude: MutableLiveData<Double> = MutableLiveData()
    var longitude: MutableLiveData<Double> = MutableLiveData()
}
