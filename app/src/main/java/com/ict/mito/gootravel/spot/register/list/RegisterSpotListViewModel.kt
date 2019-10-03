package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.RegisterPointData

class RegisterSpotListViewModel : ViewModel() {
    private var registerSpotList: MutableLiveData<List<RegisterPointData>> = MutableLiveData()
    var adapter: RegisterSpotListAdapter =
        RegisterSpotListAdapter(registerSpotList.value ?: listOf())
}
