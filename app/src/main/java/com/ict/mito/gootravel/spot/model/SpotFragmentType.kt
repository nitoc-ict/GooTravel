package com.ict.mito.gootravel.spot.model

import com.ict.mito.gootravel.R

/**
 * Created by mitohato14 on 2019-11-04.
 */
enum class SpotFragmentType(
    val titleId: Int
) {
    RADAR(R.string.wifi_spot),
    LIST(R.string.wifi_spot),
    SEARCH(R.string.appbar_search_title),
    NAVIGATE(R.string.navigate),
    REGISTER_LIST(R.string.register_fragment_title),
    RAGISTER(R.string.register_fragment_title)
}