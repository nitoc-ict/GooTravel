package com.ict.mito.gootravel.spot.select.radar.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RadarFragmentBinding
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import com.ict.mito.gootravel.spot.model.SpotData
import com.ict.mito.gootravel.spot.model.SpotFragmentType
import com.ict.mito.gootravel.spot.model.viewmodel.SpotSharedViewModel
import com.ict.mito.gootravel.util.calcDirectDistance
import com.ict.mito.gootravel.util.calcDirection
import com.ict.mito.gootravel.util.deg2rad
import kotlinx.android.synthetic.main.activity_spot.bottom_appbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.dip
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext
import kotlin.math.cos
import kotlin.math.sin

class RadarFragment : Fragment() {
    private val job = Job()
    private val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private val coroutineScope = CoroutineScope(coroutineContext)

    val viewModel: RadarViewModel by viewModel()
    private val sharedViewModel: SpotSharedViewModel by sharedViewModel()
    private var binding: RadarFragmentBinding? = null

    private lateinit var constraintLayout: ConstraintLayout
    private val constraintSet = ConstraintSet()

    private val onMenuItemClickListener = Toolbar.OnMenuItemClickListener { menu ->
        when (menu.itemId) {
            R.id.appbar_list -> {
                findNavController().navigate(R.id.action_radarFragment_to_listFragment)
            }
            R.id.appbar_search -> {
                findNavController().navigate(R.id.action_radarFragment_to_searchFragment)
            }
            R.id.app_bar_manual -> {
                startActivity(
                    Intent(
                        context,
                        ManualActivity::class.java
                    )
                )
            }
            R.id.app_bar_language -> {
                startActivity(
                    Intent(
                        context,
                        SettingActivity::class.java
                    )
                )
            }
            R.id.app_bar_register -> {
                findNavController().navigate(R.id.action_radarFragment_to_registerSpotListFragment)
            }
            else -> {
                findNavController().navigate(R.id.action_radarFragment_to_registerFragment)
            }
        }
        true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.bottom_appbar?.setOnMenuItemClickListener(onMenuItemClickListener)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.radar_fragment,
            container,
            false
        )

        constraintLayout = binding?.root as ConstraintLayout
        constraintSet.clone(constraintLayout)

        coroutineScope.launch {
            while (true) {
                withContext(Dispatchers.Main) {
                    removeSpotButton()
                    displaySpotButton()

                    constraintSet.applyTo(constraintLayout)
                }
                delay(5000L)
            }
        }

        viewModel.also {
            it.fragmentManager = parentFragmentManager
            it.locationLiveData.observe(
                viewLifecycleOwner,
                Observer { }
            )
            it.orientationLiveData.observe(
                viewLifecycleOwner,
                Observer { }
            )
            it.navController = findNavController()
        }

        sharedViewModel.fragmentType.postValue(SpotFragmentType.RADAR)

        binding?.let {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }

        checkArgumentAndTransition()

        return binding?.root
    }

    private fun displaySpotButton() {
        val displaySpotList = viewModel.filterSpotData()
        displaySpotList.forEach { destinationSpot ->
            val distance = getDirectDistance(destinationSpot)
            val directionRad = getDirectionRad(destinationSpot)

            addWiFiSpotButton(
                destinationSpot.id.toInt(),
                (distance * sin(directionRad)).toInt(),
                (distance * cos(directionRad)).toInt()
            )
        }
    }

    private fun getDirectDistance(destinationSpot: SpotData): Double {
        return calcDirectDistance(
            destinationSpot,
            viewModel.locationLiveData.value
        )
    }

    private fun getDirectionRad(destinationSpot: SpotData): Double {
        val direction = calcDirection(
            destinationSpot,
            viewModel.locationLiveData.value
        )

        return deg2rad(
            direction + (viewModel.orientationLiveData.value?.azimuth ?: 0f)
        )
    }

    private fun removeSpotButton() {
        viewModel.showSpotViewList.forEach { button ->
            constraintLayout.removeView(button)
        }
        viewModel.showSpotViewList.clear()
    }

    private fun checkArgumentAndTransition() {
        val args = arguments ?: return
        val safeArgs = RadarFragmentArgs.fromBundle(args)
        val id = safeArgs.spotId.toInt()
        val distance = safeArgs.distance

        if (id < 0) {
            return
        }

        viewModel.transitionBottomSheet(
            safeArgs.spotId.toInt(),
            distance
        )
    }

    private fun addWiFiSpotButton(
        id: Int,
        heightMargin: Int,
        widthMargin: Int
    ) {
        val spotButton = Button(context)
        spotButton.also {
            it.id = id
            it.setBackgroundResource(R.drawable.wifi_spot)
        }

        constraintLayout.addView(spotButton)

        constraintSet.apply {
            constrainHeight(
                spotButton.id,
                context?.dip(30) ?: 0
            )
            constrainWidth(
                spotButton.id,
                context?.dip(30) ?: 0
            )
            connect(
                spotButton.id,
                ConstraintSet.START,
                binding?.myLocation?.id ?: 0,
                ConstraintSet.START,
                context?.dip(widthMargin) ?: 0
            )
            connect(
                spotButton.id,
                ConstraintSet.TOP,
                binding?.myLocation?.id ?: 0,
                ConstraintSet.TOP,
                context?.dip(heightMargin) ?: 0
            )
        }

        spotButton.setOnClickListener(viewModel.spotClickListener)
        viewModel.showSpotViewList.add(spotButton)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
        binding = null
    }
}
