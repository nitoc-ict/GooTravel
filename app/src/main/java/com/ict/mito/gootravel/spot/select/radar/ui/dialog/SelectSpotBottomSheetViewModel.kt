package com.ict.mito.gootravel.spot.select.radar.ui.dialog

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.spot.select.radar.ui.RadarFragmentDirections

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheetViewModel(private val repository: Repository) : ViewModel() {
    private val _spotData: MutableLiveData<SpotData> = MutableLiveData()
    val spotData: LiveData<SpotData>
        get() = _spotData

    var distance: String = "0m"

    var navController: NavController? = null
    var dialog: BottomSheetDialogFragment? = null

    fun setId(id: Long) {
        repository.getSpotDataById(id).map {
            _spotData.postValue(it)
        }.subscribe()
    }

    fun goClick(view: View) {
        val action =
            RadarFragmentDirections.actionRadarFragmentToNavigateFragment(_spotData.value?.id ?: 0)
        navController?.navigate(action)
        dialog?.dismiss()
    }

    fun registerClick(view: View) {
        val action =
            RadarFragmentDirections.actionRadarFragmentToRegisterFragment(_spotData.value?.id ?: 0)
        navController?.navigate(action)
        dialog?.dismiss()
    }
}
