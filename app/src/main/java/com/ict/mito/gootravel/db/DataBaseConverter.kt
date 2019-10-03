package com.ict.mito.gootravel.db

import com.ict.mito.gootravel.spot.model.RegisterPointData
import java.nio.ByteBuffer

/**
 * Created by mitohato14 on 2019-08-28.
 */
class DataBaseConverter {
    fun convert2RoomRegisterLocation(registerPointData: RegisterPointData): RoomRegisterLocation {
        val byteBuffer = ByteBuffer.allocate(registerPointData.spotBitmap.byteCount)
        registerPointData.spotBitmap.copyPixelsToBuffer(byteBuffer)
        val imageByteArray = byteBuffer.array()

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
