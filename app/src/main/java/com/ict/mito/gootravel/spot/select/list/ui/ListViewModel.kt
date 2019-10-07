package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem
import com.ict.mito.gootravel.util.calcDirectDistance
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import io.reactivex.rxkotlin.subscribeBy

class ListViewModel(
    private val repository: Repository,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    val rowBindableItem: MutableLiveData<List<ListRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            syncSpotData()
        }

    init {
        syncSpotData()
    }

    fun calcSpotDistance() {
        rowBindableItem.value?.map { spot ->
            val distance = calcDirectDistance(
                spot.wiFiSpotListItem.spotData,
                locationLiveData.value
            ).toInt()
            spot.wiFiSpotListItem.distanceString = distance.toString()
        }
    }

    fun syncSpotData() {
        repository.getAllSpotData().subscribeBy(
            onSuccess = {
                val spotDataArray: ArrayList<ListRowItem> = arrayListOf()
                it.forEach { spot ->
                    spotDataArray.add(
                        ListRowItem(
                            WiFiSpotListItem(
                                spot,
                                "-"
                            ),
                            navController ?: return@subscribeBy
                        )
                    )
                }
                rowBindableItem.postValue(spotDataArray)
            }
        )
    }
}
