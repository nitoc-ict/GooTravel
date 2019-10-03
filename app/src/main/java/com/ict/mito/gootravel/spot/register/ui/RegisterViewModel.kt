package com.ict.mito.gootravel.spot.register.ui

import android.app.TimePickerDialog
import android.graphics.Bitmap
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.RegisterPointData
import java.util.Calendar

class RegisterViewModel(private val repository: Repository) : ViewModel() {
    private val _registerPointLiveData = MutableLiveData<RegisterPointData>()
    val registerPointLiveData: LiveData<RegisterPointData>
        get() = _registerPointLiveData

    val nameLiveData = MutableLiveData<String>()
    val memoLiveData = MutableLiveData<String>()

    lateinit var navController: NavController

    fun setImage(bitmap: Bitmap) {
        _registerPointLiveData.postValue(_registerPointLiveData.value?.copy(spotBitmap = bitmap))
    }

    val doneClick = View.OnClickListener {
        val spotName = nameLiveData.value ?: ""
        val spotMemo = memoLiveData.value ?: ""

        if (spotName.isNotEmpty()) {
            _registerPointLiveData.postValue(
                _registerPointLiveData.value?.copy(
                    name = spotName,
                    memo = spotMemo
                )
            )
            _registerPointLiveData.value?.let {
                repository.add(
                    DataBaseConverter().convert2RoomRegisterLocation(it)
                )
            }
        }
        navController.navigate(R.id.action_registerFragment_to_radarFragment)
    }

    val setNotificationClick = View.OnClickListener { view ->
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minuteNow = calendar.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(
            view.context,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                _registerPointLiveData.postValue(
                    _registerPointLiveData.value?.copy(notificationTime = hourOfDay * 100 + minute)
                )
            },
            hour,
            minuteNow,
            true
        )
        dialog.show()
    }
}
