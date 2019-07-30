package com.ict.mito.gootravel.spot.navigate.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.NavigateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class NavigateFragment : Fragment() {

    private val viewModel: NavigateViewModel by viewModel()
    private var binding: NavigateFragmentBinding? = null
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

    @SuppressLint("MissingPermission")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        googleApiClient = GoogleApiClient.Builder(context!!)
            .addConnectionCallbacks(googleApiClientConnectionCallbacks)
            .addOnConnectionFailedListener(googleConnectionFailedListener)
            .addApi(LocationServices.API)
            .build()

        createLocationRequest()
        val locationClient = LocationServices.getFusedLocationProviderClient(context!!)
        locationClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)
                    p0?.let { updateLocationInfo(it.lastLocation) }
                }
            },
            Looper.myLooper()
        )
        locationClient.lastLocation
            .addOnSuccessListener {
                updateLocationInfo(it)
            }
    }

    private fun updateLocationInfo(location: Location) {
        Timber.d("latitude:${location.latitude}")
        Timber.d("longitude:${location.longitude}")
        viewModel.also {
            it.latitude.postValue(location.latitude)
            it.longitude.postValue(location.longitude)
        }
        rotateImage(viewModel.direction.value?.toDouble() ?: 0.0)
        binding?.notifyChange()
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.also {
            it.interval = 1000
            it.fastestInterval = 500
            it.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.navigate_fragment,
            container,
            false

        )

        val viewmodelObserver = Observer<String> {
            binding?.let {
                it.viewmodel = viewModel
                it.notifyChange()
            }
        }

        viewModel.also {
            it.direction.observe(
                this,
                viewmodelObserver
            )
            it.distance.observe(
                this,
                viewmodelObserver
            )
        }

        binding?.viewmodel = viewModel

        return binding?.root
    }

    private fun rotateImage(angle: Double) {
        val image = BitmapFactory.decodeResource(
            resources,
            R.drawable.arrow
        )
        val matrix = Matrix()
        matrix.setRotate(
            angle.toFloat(),
            image.width / 2f,
            image.height / 4f
        )
        val afterImage = Bitmap.createBitmap(
            image,
            0,
            0,
            image.width,
            image.height,
            matrix,
            true
        )
        binding?.arrowImage?.setImageBitmap(afterImage)
    }

    override fun onStart() {
        super.onStart()
        googleApiClient.connect()
    }

    override fun onStop() {
        super.onStop()
        googleApiClient.disconnect()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
