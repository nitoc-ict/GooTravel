package com.ict.mito.gootravel.wifi.connect.model

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData

/**
 * Created by mitohato14 on 2019-09-18.
 */
class NetworkStateLiveData(private val context: Context) : LiveData<Boolean>() {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}