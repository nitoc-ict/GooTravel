package com.ict.mito.gootravel.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ict.mito.gootravel.db.dao.RegisterDataDAO
import com.ict.mito.gootravel.spot.model.SpotData

/**
 * Created by mitohato14 on 2019-08-28.
 */
@Database(
    entities = [
        RoomRegisterLocation::class,
        SpotData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GooTravelDataRoomDataBase : RoomDatabase() {
    abstract fun dao(): RegisterDataDAO

    companion object {
        @Volatile
        private var INSTANCE: GooTravelDataRoomDataBase? = null

        fun getDataBase(context: Context): GooTravelDataRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GooTravelDataRoomDataBase::class.java,
                    "gootravel_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
