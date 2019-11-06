package com.ict.mito.gootravel.spot.model

import com.ict.mito.gootravel.R

/**
 * Created by mitohato14 on 2019-11-04.
 */
enum class SpotFragmentType(
    val titleId: Int,
    val menuId: Int,
    val enableBack: Boolean
) {
    RADAR(
        R.string.wifi_spot,
        R.menu.radar_bottomappbar_menu,
        false
    ),
    LIST(
        R.string.wifi_spot,
        R.menu.list_bottomappbar_menu,
        false
    ),
    SEARCH(
        R.string.appbar_search_title,
        R.menu.search_bottomappbar_menu,
        false
    ),
    NAVIGATE(
        R.string.navigate,
        R.menu.empty_menu,
        true
    ),
    REGISTER_LIST(
        R.string.register_fragment_title,
        R.menu.empty_menu,
        true
    ),
    REGISTER(
        R.string.register_fragment_title,
        R.menu.empty_menu,
        true
    )
}