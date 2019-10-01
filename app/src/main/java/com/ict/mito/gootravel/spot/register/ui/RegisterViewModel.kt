package com.ict.mito.gootravel.spot.register.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.ict.mito.gootravel.spot.model.RegisterPointData

class RegisterViewModel : ViewModel() {
    private val _registerPointLiveData = MutableLiveData<RegisterPointData>()
    val registerPointLiveData: LiveData<RegisterPointData>
        get() = _registerPointLiveData
}
