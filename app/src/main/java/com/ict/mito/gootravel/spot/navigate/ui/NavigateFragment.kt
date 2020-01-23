package com.ict.mito.gootravel.spot.navigate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.NavigateFragmentBinding
import com.ict.mito.gootravel.spot.model.SpotFragmentType
import com.ict.mito.gootravel.spot.model.SpotSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigateFragment : Fragment() {

    private val viewModel: NavigateViewModel by viewModel()
    private val sharedViewModel: SpotSharedViewModel by sharedViewModel()
    private var binding: NavigateFragmentBinding? = null
    private var prevRotation: Int = 0

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

        val args = arguments ?: return null
        val safeArgs = NavigateFragmentArgs.fromBundle(args)

        viewModel.also {
            it.direction.observe(
                viewLifecycleOwner,
                Observer {
                    binding?.let { binding ->
                        rotateNavigateImageView(binding.arrowImage)
                        binding.notifyChange()
                    }
                }
            )
            it.distance.observe(
                viewLifecycleOwner,
                Observer {
                    binding?.let { binding ->
                        rotateNavigateImageView(binding.arrowImage)
                        binding.notifyChange()
                    }
                }
            )
            it.orientationLiveData.observe(
                viewLifecycleOwner,
                Observer { orientation ->
                    it.azimuth.postValue(orientation.azimuth.toDouble())
                }
            )
            it.locationLiveData.observe(
                viewLifecycleOwner,
                Observer { location ->
                    it.latitude.postValue(location.latitude)
                    it.longitude.postValue(location.longitude)
                }
            )
            it.destination.observe(
                viewLifecycleOwner,
                Observer {
                    binding?.notifyChange()
                }
            )
            it.setId(safeArgs.spotId)
        }

        sharedViewModel.fragmentType.postValue(SpotFragmentType.NAVIGATE)

        binding?.let {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }
        return binding?.root
    }

    private fun rotateNavigateImageView(view: ImageView) {
        val currentRotation = viewModel.direction.value?.toInt() ?: 0
        val rotate = RotateAnimation(
            prevRotation.toFloat(),
            currentRotation.toFloat(),
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.68f
        )

        rotate.fillAfter = true
        rotate.duration = 100

        view.startAnimation(rotate)
        prevRotation = currentRotation
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
