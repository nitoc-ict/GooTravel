package com.ict.mito.gootravel.spot.select.radar.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.spot.select.radar.ui.dialog.SelectSpotBottomSheetFragment
import io.reactivex.rxkotlin.subscribeBy

class RadarViewModel(private val repository: Repository) : ViewModel() {
    private var spotdataList: List<SpotData> = listOf()

    init {
        repository.getAllSpotData().subscribeBy(
            onSuccess = {
                spotdataList = it
            }
        )
    }

    lateinit var fragmentManager: FragmentManager

    fun onClickSpot(view: View) {
        val args = Bundle()
        args.putInt(
            "spotId",
            view.id
        )
        val bottomSheet = SelectSpotBottomSheetFragment()
        bottomSheet.also {
            it.arguments = args
            it.show(
                fragmentManager,
                bottomSheet.tag
            )
        }
    }
}
