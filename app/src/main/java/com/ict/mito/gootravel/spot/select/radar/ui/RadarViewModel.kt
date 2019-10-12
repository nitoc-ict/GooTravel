package com.ict.mito.gootravel.spot.select.radar.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.OrientationLiveData
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.spot.select.radar.ui.dialog.SelectSpotBottomSheetFragment
import com.ict.mito.gootravel.util.calcDirectDistance
import io.reactivex.rxkotlin.subscribeBy

class RadarViewModel(
    repository: Repository,
    val orientationLiveData: OrientationLiveData,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    var spotdataList: List<SpotData> = listOf()
    var showSpotViewList: ArrayList<View> = arrayListOf()

    lateinit var fragmentManager: FragmentManager

    val spotClickListener = View.OnClickListener { view ->
        transitionBottomSheet(view.id)
    }

    fun transitionBottomSheet(
        id: Int,
        distanse: Long = -1L
    ) {
        val clickSpot = spotdataList.first { it.id.toInt() == id }

        val args = Bundle()
        args.apply {
            putInt(
                "spotId",
                id
            )
            if (distanse == -1L) {
                putInt(
                    "distanceString",
                    calcDirectDistance(
                        clickSpot,
                        locationLiveData.value
                    ).toInt()
                )
            } else {
                putLong(
                    "distanceString",
                    distanse
                )
            }
        }

        val bottomSheet = SelectSpotBottomSheetFragment()
        bottomSheet.also {
            it.arguments = args
            it.show(
                fragmentManager,
                bottomSheet.tag
            )
        }
    }

    fun filterSpotData(): List<SpotData> {
        val location = locationLiveData.value ?: return emptyList()

        return spotdataList.filter { spot ->
            val distance = calcDirectDistance(
                spot,
                location
            )
            distance <= 500
        }
    }

    init {
        repository.getAllSpotData().subscribeBy(
            onSuccess = {
                spotdataList = it
            }
        )
    }
}
