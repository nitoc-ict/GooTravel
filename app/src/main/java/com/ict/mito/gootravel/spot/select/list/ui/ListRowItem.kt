package com.ict.mito.gootravel.spot.select.list.ui

import androidx.navigation.NavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.ListRowItemBinding
import com.ict.mito.gootravel.spot.model.WiFiSpotListItem
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by mitohato14 on 2019-07-24.
 */
class ListRowItem(
    val wiFiSpotListItem: WiFiSpotListItem,
    private val navController: NavController
) : BindableItem<ListRowItemBinding>() {
    override fun getLayout(): Int = R.layout.list_row_item

    override fun bind(
        viewBinding: ListRowItemBinding,
        position: Int
    ) {
        viewBinding.also {
            it.spot = wiFiSpotListItem
            it.root.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToRadarFragment(
                    wiFiSpotListItem.spotData.id,
                    wiFiSpotListItem.distanceString.toLong()
                )
                navController.navigate(action)
            }
        }
    }
}
