package com.ict.mito.gootravel.db

import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-08-28.
 */
class DataBaseConverter {
    fun convert2RoomRegisterLocation(registerPointData: RegisterPointData): RoomRegisterLocation {
        return RoomRegisterLocation(
            "",
            0.0,
            0.0,
            0.0,
            ByteArray(0),
            ""
        )
    }
}
