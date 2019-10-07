package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem
import com.ict.mito.gootravel.util.calcDirectDistance
import io.reactivex.rxkotlin.subscribeBy

class ListViewModel(
    private val repository: Repository,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    var spotdataList: List<WiFiSpotListItem> = listOf()
    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
        }

    init {
        syncSpotData()
    }

    fun calcSpotDistance() {
        spotdataList.map { spot ->
            val distance = calcDirectDistance(
                spot.spotData,
                locationLiveData.value
            ).toInt()
            spot.distance = distance
        }
    }

    fun syncSpotData() {
        repository.getAllSpotData().subscribeBy(
            onSuccess = {
                val spotDataArray: ArrayList<WiFiSpotListItem> = arrayListOf()
                it.forEach { spot ->
                    spotDataArray.add(
                        WiFiSpotListItem(
                            spot,
                            0
                        )
                    )
                }
                spotdataList = spotDataArray
            }
        )
    }
}
