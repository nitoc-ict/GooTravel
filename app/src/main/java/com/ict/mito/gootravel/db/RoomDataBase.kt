package com.ict.mito.gootravel.db

import androidx.room.Database

/**
 * Created by mitohato14 on 2019-08-28.
 */
@Database(
    entities = [RoomRegisterLocation::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDataBase {
}