package com.ict.mito.gootravel.spot.select.list.ui

import androidx.navigation.NavController
import com.ict.mito.gootravel.databinding.ListRowItemBinding
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by mitohato14 on 2019-07-24.
 */
class ListRowItem(
    private val wiFiSpotListItem: WiFiSpotListItem,
    private val navController: NavController
) : BindableItem<ListRowItemBinding>() {
    override fun getLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bind(viewBinding: ListRowItemBinding, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}