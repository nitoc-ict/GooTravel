package com.ict.mito.gootravel.spot.model

import com.ict.mito.gootravel.util.SpotType

/**
 * Created by mitohato14 on 2019-07-24.
 */
data class SpotData(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val spotType: SpotType,
    val spotTypeDetail: String
)
