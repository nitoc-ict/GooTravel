package com.ict.mito.gootravel.spot.select.radar.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.R

class RadarViewModel : ViewModel() {

    lateinit var navController: NavController

    fun onClickWiFi(view: View) {
        navController.navigate(R.id.action_radarFragment_to_navigateFragment)
    }
}
