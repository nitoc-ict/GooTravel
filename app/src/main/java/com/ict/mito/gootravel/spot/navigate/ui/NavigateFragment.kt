package com.ict.mito.gootravel.spot.navigate.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.NavigateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigateFragment : Fragment() {

    private val viewModel: NavigateViewModel by viewModel()
    private var locationManager: LocationManager? = null
    private var binding: NavigateFragmentBinding? = null

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            viewModel.latitude.postValue(location?.latitude)
            viewModel.longitude.postValue(location?.longitude)
            binding?.notifyChange()
        }

        override fun onStatusChanged(
            provider: String?,
            status: Int,
            extras: Bundle?
        ) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }
    }

    @SuppressLint("MissingPermission")
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

        viewModel.direction.observe(
            this,
            viewmodelObserver
        )

        viewModel.distance.observe(
            this,
            viewmodelObserver
        )
        binding?.viewmodel = viewModel

        locationManager = activity?.getSystemService(Activity.LOCATION_SERVICE) as LocationManager
        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            10L,
            1f,
            locationListener
        )
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
