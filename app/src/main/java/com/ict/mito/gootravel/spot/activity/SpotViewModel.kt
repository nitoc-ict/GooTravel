package com.ict.mito.gootravel.spot.activity

import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

/**
 * Created by mitohato14 on 2019-09-21.
 */
class SpotViewModel(private val repository: Repository) : ViewModel() {
    init {
        repository.getAllSpotData().subscribeBy(
            onSuccess = {
                if (it.isEmpty()) {
                    addSpotDataToRoomFromCSV()
                }
            },
            onError = {
                Timber.d("Error in getAllSpotData")
            }
        )
    }

    private fun addSpotDataToRoomFromCSV() {
        repository.getSpotDataByCSV().forEach {
            repository.add(it)
        }
    }
}
