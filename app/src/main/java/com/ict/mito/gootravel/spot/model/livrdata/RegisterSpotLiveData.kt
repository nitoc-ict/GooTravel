package com.ict.mito.gootravel.spot.model.livrdata

import androidx.lifecycle.MutableLiveData
import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-10-04.
 */
class RegisterSpotLiveData() : MutableLiveData<RegisterPointData>() {
    override fun onActive() {
        super.onActive()
        value = RegisterPointData(
            id = 0,
            latitude = 0.0,
            longitude = 0.0,
            name = "",
            memo = "",
            notificationTime = 0,
            spotBitmap = null
        )
    }
}
