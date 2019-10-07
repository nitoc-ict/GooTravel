package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var i : Int = 20
    var listItems : List<ListRowItem> = getItems(i)
    val adapter: ListViewAdapter = ListViewAdapter(listItems)

    private fun getItems(i : Int) : List<ListRowItem> {
        val Items : MutableList<ListRowItem> = mutableListOf()
        for  (i in 0..20) {
            Items[i] = ListRowItem("place$i", "" + i, "" + i)
        }
        return Items
    }
}
