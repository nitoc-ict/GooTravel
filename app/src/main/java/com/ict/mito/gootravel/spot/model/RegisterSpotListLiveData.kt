package com.ict.mito.gootravel.spot.model

import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import com.ict.mito.gootravel.R

/**
 * Created by mitohato14 on 2019-10-04.
 */
class RegisterSpotListLiveData(
    private val context: Context
) : LiveData<RegisterPointData>() {
    override fun onActive() {
        super.onActive()
        value = RegisterPointData(
            id = 0,
            latitude = 0.0,
            longitude = 0.0,
            name = "",
            memo = "",
            notificationTime = 0,
            spotBitmap = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.ic_location_on_black_36dp
            )
        )
    }
}