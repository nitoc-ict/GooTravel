package com.ict.mito.gootravel.db

import android.graphics.Bitmap
import com.ict.mito.gootravel.spot.model.RegisterPointData
import java.io.ByteArrayOutputStream

/**
 * Created by mitohato14 on 2019-08-28.
 */
class DataBaseConverter {
    fun convert2RoomRegisterLocation(registerPointData: RegisterPointData): RoomRegisterLocation {
        val baos = ByteArrayOutputStream()
        registerPointData.spotBitmap.compress(
            Bitmap.CompressFormat.JPEG,
            100,
            baos
        )
        val imageByteArray = baos.toByteArray()

        return RoomRegisterLocation(
            name = registerPointData.name,
            latitude = registerPointData.latitude,
            longitude = registerPointData.longitude,
            notificationTime = registerPointData.notificationTime.toDouble(),
            image = imageByteArray,
            memo = registerPointData.memo
        )
    }
}
