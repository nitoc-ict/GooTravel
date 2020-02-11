package com.ict.mito.gootravel.spot.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.SpotFragmentType

/**
 * Created by mitohato14 on 2019-11-04.
 */
class SpotSharedViewModel : ViewModel() {
    val fragmentType: MutableLiveData<SpotFragmentType> = MutableLiveData()

    init {
        fragmentType.postValue(SpotFragmentType.RADAR)
    }
}
