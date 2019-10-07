package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.SpotData

class ListViewModel : ViewModel() {

    var spotdataList: List<SpotData> = listOf()
    var listItems : List<ListRowItem> = listOf()
    val adapter: ListViewAdapter = ListViewAdapter(listItems)

    private fun getItems(i : Int) : List<ListRowItem> {
        val Items : MutableList<ListRowItem> = mutableListOf()
        for  (i in 0..20) {
            Items[i] = ListRowItem("place$i", "" + i, "" + i)
        }
        return Items
    }
}
