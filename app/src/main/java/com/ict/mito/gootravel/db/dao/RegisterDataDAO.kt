package com.ict.mito.gootravel.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ict.mito.gootravel.db.RoomRegisterLocation
import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-08-28.
 */
@Dao
interface RegisterDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(location: RoomRegisterLocation)

    @Query("SELECT * FROM gootravel_table")
    fun getAll(): Single<List<RoomRegisterLocation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(spotData: SpotData)

    @Query("SELECT * FROM spotdata")
    fun getAllSpotData(): Single<List<SpotData>>
}
