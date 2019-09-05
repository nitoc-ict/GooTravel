package com.ict.mito.gootravel.repo

import com.ict.mito.gootravel.db.RoomRegisterLocation
import com.ict.mito.gootravel.spot.model.SpotData

/**
 * Created by mitohato14 on 2019-09-05.
 */
interface WriteRepository {
    fun add(spotData: SpotData)
    fun add(roomRegisterLocation: RoomRegisterLocation)
}