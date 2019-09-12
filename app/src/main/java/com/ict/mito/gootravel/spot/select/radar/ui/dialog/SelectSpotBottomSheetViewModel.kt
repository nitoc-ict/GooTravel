package com.ict.mito.gootravel.spot.select.radar.ui.dialog

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheetViewModel(private val repository: Repository) : ViewModel() {
    private val _spotData: MutableLiveData<SpotData> = MutableLiveData()
    val spotData: LiveData<SpotData>
        get() = _spotData

    val distance: String = "0m"

    var navController: NavController? = null

    fun setId(id: Long) {
//        repository.getSpotDataById(id).map {
//            _spotData.postValue(it)
//        }.subscribe()
    }

    fun spotClick(view: View) {
        navController?.navigate(R.id.action_radarFragment_to_navigateFragment)
    }
}
