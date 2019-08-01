package com.ict.mito.gootravel.spot.model

import android.content.Context
import android.location.Location
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import timber.log.Timber

/**
 * Created by mitohato14 on 2019-08-01.
 */
class LocationLiveData(
    val context: Context
) : LiveData<Location>() {
    private lateinit var googleApiClient: GoogleApiClient
    private lateinit var locationRequest: LocationRequest

    private val googleConnectionFailedListener = GoogleApiClient.OnConnectionFailedListener {
        Timber.d("ConnectionFailed")
        Timber.d(it.errorCode.toString())
    }

    private val googleApiClientConnectionCallbacks = object : GoogleApiClient.ConnectionCallbacks {
        override fun onConnected(p0: Bundle?) {
            Timber.d("onConnected")
        }

        override fun onConnectionSuspended(p0: Int) {
            Timber.d("onConnectionSuspended")
            googleApiClient.connect()
        }
    }

}