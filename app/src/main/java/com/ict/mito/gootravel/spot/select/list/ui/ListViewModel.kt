package com.ict.mito.gootravel.spot.select.list.ui

import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var i : Int = 20
    var ListItems : List<ListRowItemx> = getItems(i)

    private fun getItems(i : Int) : List<ListRowItemx> {
        val Items : MutableList<ListRowItemx> = mutableListOf()
        for  (i in 0..20) {
            Items[i] = ListRowItemx("place$i", "" + i, "" + i)
        }
        return Items
    }
}
