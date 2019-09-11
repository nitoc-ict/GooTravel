package com.ict.mito.gootravel.spot.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by mitohato14 on 2019-07-24.
 */
@Entity
data class SpotData(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val spotType: Int,
    val spotTypeDetail: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
