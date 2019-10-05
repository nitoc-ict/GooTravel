package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.MutableLiveData
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
    var adapter: RegisterSpotListAdapter =
        RegisterSpotListAdapter(registerSpotListLiveData.value ?: listOf())
    val rowBindableItemList: MutableLiveData<List<RegisterSpotListRowItem>> = MutableLiveData()

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            adapter.navController = value
        }

    init {
        syncListWithRoom()
    }

    fun syncListWithRoom() {
        repository.getAllRegisterLocation().subscribeBy(
            onSuccess = {
                if (registerSpotListLiveData.value == null) {
                    registerSpotListLiveData.value =
                        DataBaseConverter().convert2RegisterPointDataList(it)
                } else {
                    registerSpotListLiveData.postValue(
                        DataBaseConverter().convert2RegisterPointDataList(
                            it
                        )
                    )
                }
            }
        )
        adapter.setSpotList(registerSpotListLiveData.value ?: listOf())
    }
}
