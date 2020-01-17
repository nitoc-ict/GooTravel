package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.util.calcDirectDistance
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class RegisterSpotListViewModel(
    private val repository: Repository,
    val locationLiveData: LocationLiveData
) : ViewModel() {
    val rowBindableItemList: MutableLiveData<List<RegisterSpotListRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            syncListWithRoom()
        }

    init {
        syncListWithRoom()
    }

    fun update() {
        syncListWithRoom()
    }

    fun syncListWithRoom() {
        repository.getAllRegisterLocation()
            .subscribeOn(Schedulers.io())
            .subscribeBy(
            onSuccess = {
                val rowItemArray = arrayListOf<RegisterSpotListRowItem>()
                it.forEach { spot ->
                    rowItemArray.add(
                        RegisterSpotListRowItem(
                            DataBaseConverter().convert2RegisterPointData(
                                spot
                            ),
                            navController ?: return@subscribeBy,
                            calcDirectDistance(
                                spot.longitude,
                                spot.latitude,
                                locationLiveData.value?.longitude ?: 0.0,
                                locationLiveData.value?.latitude ?: 0.0
                            ).toLong()
                        )
                    )
                }

                rowBindableItemList.postValue(rowItemArray)
            }
        )
    }
}
