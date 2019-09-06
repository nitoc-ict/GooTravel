package com.ict.mito.gootravel.repo

import com.ict.mito.gootravel.db.RoomRegisterLocation
import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-09-05.
 */
interface ReadRepository {
    fun getSpotDataById(id: Long): Single<SpotData>
    fun getAllSpotData(): Single<List<SpotData>>

    fun getRegisterLocationById(id: Long): Single<RoomRegisterLocation>
    fun getAllRegisterLocation(): Single<List<RoomRegisterLocation>>
}