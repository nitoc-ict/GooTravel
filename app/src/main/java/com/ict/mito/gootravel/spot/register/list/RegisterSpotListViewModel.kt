package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.RegisterSpotListLiveData
import io.reactivex.rxkotlin.subscribeBy

class RegisterSpotListViewModel(
    private val repository: Repository,
    val registerSpotListLiveData: RegisterSpotListLiveData
) : ViewModel() {
//    var registerSpotList: MutableLiveData<List<RegisterPointData>> = MutableLiveData()
    var adapter: RegisterSpotListAdapter =
        RegisterSpotListAdapter(registerSpotListLiveData.value ?: listOf())

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            adapter.navController = value
        }

    init {
        registerSpotListLiveData.value = listOf()
        repository.getAllRegisterLocation().subscribeBy(
            onSuccess = {
                registerSpotListLiveData.postValue(DataBaseConverter().convert2RegisterPointDataList(it))
            }
        )
    }
}
