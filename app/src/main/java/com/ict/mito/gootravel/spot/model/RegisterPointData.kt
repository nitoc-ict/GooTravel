package com.ict.mito.gootravel.spot.model

import android.graphics.Bitmap

/**
 * Created by mitohato14 on 2019-07-23.
 */
data class RegisterPointData(
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val memo: String,
    val notificationTime: Int,
    val spotBitmap: Bitmap
)
