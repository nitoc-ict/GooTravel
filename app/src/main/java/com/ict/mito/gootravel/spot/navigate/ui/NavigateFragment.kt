package com.ict.mito.gootravel.spot.navigate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.NavigateFragmentBinding
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.util.rad2deg
import com.ict.mito.gootravel.util.rotateImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigateFragment : Fragment() {

    private val viewModel: NavigateViewModel by viewModel()
    private var binding: NavigateFragmentBinding? = null

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
                val image = rotateImage(
                    resources,
                    viewModel.direction.value?.toDouble() ?: 0.0
                )
                it.arrowImage?.setImageBitmap(image)
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
            it.orientationLiveData.observe(
                this,
                Observer { orientation ->
                    it.azimuth.postValue(rad2deg(orientation.azimuth))
                }
            )
            it.locationLiveData.observe(
                this,
                Observer { location ->
                    it.latitude.postValue(location.latitude)
                    it.longitude.postValue(location.longitude)
                }
            )
            it.spotData = SpotData(
                "Dummy",
                0.0,
                0.0,
                0,
                ""
            )
        }

        binding?.viewmodel = viewModel

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
