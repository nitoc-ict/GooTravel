package com.ict.mito.gootravel.repo

import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-09-05.
 */
interface ReadRepository {
    fun getSpotDataById(id: Long): Maybe<SpotData>
    fun getAllSpotData(): Single<List<SpotData>>
}