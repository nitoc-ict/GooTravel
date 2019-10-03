package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.spot.model.RegisterPointData

class RegisterSpotListViewModel : ViewModel() {
    private lateinit var registerSpotList: List<RegisterPointData>
    var adapter: RegisterSpotListAdapter = RegisterSpotListAdapter(registerSpotList)
}
