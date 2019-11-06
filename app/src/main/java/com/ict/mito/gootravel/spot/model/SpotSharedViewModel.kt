package com.ict.mito.gootravel.spot.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by mitohato14 on 2019-11-04.
 */
class SpotSharedViewModel : ViewModel() {
    val fragmentType: MutableLiveData<SpotFragmentType> = MutableLiveData()

    init {
        fragmentType.postValue(SpotFragmentType.RADAR)
    }
}
