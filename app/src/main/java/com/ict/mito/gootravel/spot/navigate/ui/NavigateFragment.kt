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

class NavigateFragment : Fragment(), LocationListener {

    private val viewModel: NavigateViewModel by viewModel()
    private var locationManager: LocationManager? = null
    private var binding: NavigateFragmentBinding? = null

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

        viewModel.latitude.observe(
            this,
            viewmodelObserver
        )
        viewModel.longitude.observe(
            this,
            viewmodelObserver
        )
        binding?.viewmodel = viewModel

        locationManager = activity?.getSystemService(Activity.LOCATION_SERVICE) as LocationManager
        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000L,
            50f,
            this
        )
        return binding?.root
    }

    override fun onLocationChanged(location: Location?) {
        viewModel.latitude.value = location?.latitude.toString()
        viewModel.longitude.value = location?.longitude.toString()
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
