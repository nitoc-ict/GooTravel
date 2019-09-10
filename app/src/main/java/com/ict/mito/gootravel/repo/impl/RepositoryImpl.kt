package com.ict.mito.gootravel.repo.impl

import com.ict.mito.gootravel.csv.CSVReader
import com.ict.mito.gootravel.db.RoomRegisterLocation
import com.ict.mito.gootravel.db.dao.RegisterDataDAO
import com.ict.mito.gootravel.db.dao.SpotDataDAO
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-09-05.
 */
class RepositoryImpl(
    private val registerDataDAO: RegisterDataDAO,
    private val spotDataDAO: SpotDataDAO,
    private val csvReader: CSVReader
) : Repository {
    override fun getSpotDataByCSV(): Single<List<SpotData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(spotData: SpotData) = spotDataDAO.insert(spotData)

    override fun add(roomRegisterLocation: RoomRegisterLocation) =
        registerDataDAO.insert(roomRegisterLocation)

    override fun getSpotDataById(id: Long): Single<SpotData> {
        return getAllSpotData().map { list ->
            list.first { it.id == id }
        }
    }

    override fun getAllSpotData(): Single<List<SpotData>> = spotDataDAO.getAllSpotData()

    override fun getRegisterLocationById(id: Long): Single<RoomRegisterLocation> {
        return getAllRegisterLocation().map { list ->
            list.first { it.id == id }
        }
    }

    override fun getAllRegisterLocation(): Single<List<RoomRegisterLocation>> =
        registerDataDAO.getAllRegister()
}
