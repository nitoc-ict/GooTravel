package com.ict.mito.gootravel.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by mitohato14 on 2019-08-28.
 */
@Entity(tableName = "gootravel_table")
data class RoomRegisterLocation(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val notificationTime: Double,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) val image: ByteArray,
    val memo: String,
    @PrimaryKey var id: Long = 0
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RoomRegisterLocation

        if (name != other.name) return false
        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false
        if (notificationTime != other.notificationTime) return false
        if (!image.contentEquals(other.image)) return false
        if (memo != other.memo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + notificationTime.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + memo.hashCode()
        return result
    }
}
