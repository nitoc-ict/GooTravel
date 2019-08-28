package com.ict.mito.gootravel.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ict.mito.gootravel.db.RoomRegisterLocation

/**
 * Created by mitohato14 on 2019-08-28.
 */
@Dao
interface RegisterDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(location: RoomRegisterLocation)
}