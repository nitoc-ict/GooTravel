package com.ict.mito.gootravel.spot.model

import androidx.lifecycle.MutableLiveData

/**
 * Created by mitohato14 on 2019-10-04.
 */
class RegisterSpotListLiveData : MutableLiveData<List<RegisterPointData>>() {
    override fun onActive() {
        super.onActive()
        value = listOf()
    }
}
