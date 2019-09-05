package com.ict.mito.gootravel.repo.impl

import com.ict.mito.gootravel.db.RoomRegisterLocation
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-09-05.
 */
class RepositoryImpl : Repository {
    override fun add(spotData: SpotData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(roomRegisterLocation: RoomRegisterLocation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSpotDataById(id: Long): Maybe<SpotData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllSpotData(): Single<List<SpotData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRegisterLocationById(id: Long): Maybe<RoomRegisterLocation> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllRegisterLocation(): Single<List<RoomRegisterLocation>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}