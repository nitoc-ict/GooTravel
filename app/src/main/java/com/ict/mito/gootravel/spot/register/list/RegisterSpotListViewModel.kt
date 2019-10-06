package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import io.reactivex.rxkotlin.subscribeBy

class RegisterSpotListViewModel(
    private val repository: Repository
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

    fun syncListWithRoom() {
        repository.getAllRegisterLocation().subscribeBy(
            onSuccess = {
                val rowItemArray = arrayListOf<RegisterSpotListRowItem>()
                it.forEach { spot ->
                    rowItemArray.add(
                        RegisterSpotListRowItem(
                            DataBaseConverter().convert2RegisterPointData(
                                spot
                            ),
                            navController ?: return@subscribeBy
                        )
                    )
                }

                rowBindableItemList.postValue(rowItemArray)
            }
        )
    }
}
