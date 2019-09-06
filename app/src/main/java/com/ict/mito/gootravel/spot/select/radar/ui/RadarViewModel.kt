package com.ict.mito.gootravel.spot.select.radar.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.spot.select.radar.ui.dialog.SelectSpotBottomSheetFragment

class RadarViewModel : ViewModel() {

    lateinit var navController: NavController
    lateinit var fragmentManager: FragmentManager

    fun onClickWiFi(view: View) {
        navController.navigate(R.id.action_radarFragment_to_navigateFragment)
    }

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
