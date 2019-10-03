package com.ict.mito.gootravel.spot.register.ui

import android.app.TimePickerDialog
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.gootravel.db.DataBaseConverter
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.spot.model.RegisterPointData
import java.util.*

class RegisterViewModel(private val repository: Repository) : ViewModel() {
    private val _registerPointLiveData = MutableLiveData<RegisterPointData>()
    val registerPointLiveData: LiveData<RegisterPointData>
        get() = _registerPointLiveData

    val nameLiveData = MutableLiveData<String>()
    val memoLiveData = MutableLiveData<String>()

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
    }

    val setNotificationClick = View.OnClickListener { view ->
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(
            view.context,
            TimePickerDialog.OnTimeSetListener { _, _, _ -> },
            hour,
            minute,
            true
        )
        dialog.show()

    }
}
