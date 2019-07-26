package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigateViewModel : ViewModel() {
    var latitude: MutableLiveData<String> = MutableLiveData()
    var longitude: MutableLiveData<String> = MutableLiveData()
}
