package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem
import io.reactivex.rxkotlin.subscribeBy

class ListViewModel(
    private val repository: Repository,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    var spotdataList: List<WiFiSpotListItem> = listOf()

    var listItems: List<ListRowItem> = listOf()
    val adapter: ListViewAdapter = ListViewAdapter(listItems)

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
