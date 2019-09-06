package com.ict.mito.gootravel.spot.select.radar.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.select.radar.ui.dialog.SelectSpotBottomSheetFragment

class RadarViewModel : ViewModel() {
    lateinit var fragmentManager: FragmentManager

    fun onClickSpot(view: View) {
        val args = Bundle()
        args.putInt(
            "spotId",
            view.id
        )
        val bottomSheet = SelectSpotBottomSheetFragment()
        bottomSheet.arguments = args
        bottomSheet.show(
            fragmentManager,
            bottomSheet.tag
        )
    }
}
