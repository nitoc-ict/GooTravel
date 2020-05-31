package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.spot.model.livrdata.LocationLiveData
import com.ict.mito.gootravel.spot.model.livrdata.OrientationLiveData
import com.ict.mito.gootravel.util.calcDirectDistance
import com.ict.mito.gootravel.util.calcDirection
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.runBlocking

class NavigateViewModel(
    val orientationLiveData: OrientationLiveData,
    val locationLiveData: LocationLiveData,
    private val repository: Repository
) : ViewModel() {
    var latitude: MutableLiveData<Double> = MutableLiveData()
    var longitude: MutableLiveData<Double> = MutableLiveData()
    var azimuth: MutableLiveData<Double> = MutableLiveData()
    var direction: MediatorLiveData<Double> = MediatorLiveData()
    var distance: MediatorLiveData<Int> = MediatorLiveData()

    val destination: LiveData<SpotData>
        get() = _destination
    private val _destination: MutableLiveData<SpotData> = MutableLiveData()

    fun setId(id: Long) {
        runBlocking {
            repository.getSpotDataById(id)
                .map {
                    _destination.postValue(it)
                }
                .subscribeOn(Schedulers.io())
                .subscribe()
        }
    }

    init {
        val observer = Observer<Double> {
            direction.postValue(
                calcDirection(
                    destination.value?.longitude ?: 0.0,
                    destination.value?.latitude ?: 0.0,
                    longitude.value ?: 0.0,
                    latitude.value ?: 0.0
                ) - (azimuth.value ?: 0.0)
            )
            distance.postValue(
                calcDirectDistance(
                    destination.value?.longitude ?: 0.0,
                    destination.value?.latitude ?: 0.0,
                    longitude.value ?: 0.0,
                    latitude.value ?: 0.0
                ).toInt()
            )
        }
        direction.apply {
            addSource(
                latitude,
                observer
            )
            addSource(
                longitude,
                observer
            )
            addSource(
                azimuth,
                observer
            )
        }

        distance.apply {
            addSource(
                latitude,
                observer
            )
            addSource(
                longitude,
                observer
            )
        }
    }
}
