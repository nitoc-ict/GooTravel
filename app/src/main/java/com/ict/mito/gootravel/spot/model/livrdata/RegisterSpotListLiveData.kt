package com.ict.mito.gootravel.spot.model.livrdata

import androidx.lifecycle.MutableLiveData
import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-10-04.
 */
class RegisterSpotListLiveData : MutableLiveData<List<RegisterPointData>>() {
    override fun onActive() {
        super.onActive()
        value = listOf()
    }
}
