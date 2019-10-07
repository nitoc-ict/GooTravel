package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem

class ListViewModel(
    private val repository: Repository,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    var spotdataList: List<WiFiSpotListItem> = listOf()

    var listItems: List<ListRowItem> = listOf()
    val adapter: ListViewAdapter = ListViewAdapter(listItems)

    private fun getItems(i: Int): List<ListRowItem> {
        val Items: MutableList<ListRowItem> = mutableListOf()
        for (i in 0..20) {
            Items[i] = ListRowItem("place$i", "" + i, "" + i)
        }
        return Items
    }
}
