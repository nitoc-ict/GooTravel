package com.ict.mito.gootravel.spot.select.radar.ui

import android.content.Intent
import android.location.Location
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
import com.ict.mito.gootravel.util.RADAR_DISPLAY_RANGE
import com.ict.mito.gootravel.util.calcDirectDistance
import com.ict.mito.gootravel.util.calcDirection
import kotlinx.android.synthetic.main.activity_spot.*
import org.jetbrains.anko.dip
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.cos
import kotlin.math.sin

class RadarFragment : Fragment() {

    private val viewModel: RadarViewModel by viewModel()
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
        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.radar_bottomappbar_menu)
            activity?.bottom_appbar?.setOnMenuItemClickListener(onMenuItemClickListener)
        }

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.radar_fragment,
            container,
            false
        )

        constraintLayout = binding?.root as ConstraintLayout
        constraintSet.clone(constraintLayout)

        viewModel.also {
            it.fragmentManager = parentFragmentManager
            it.locationLiveData.observe(
                this,
                Observer { value ->
                    viewModel.showSpotViewList.forEach { button ->
                        constraintLayout.removeView(button)
                    }
                    viewModel.showSpotViewList.clear()
                    val array = filterSpotData(value)
                    array.forEach { spot ->
                        val distance = calcDirectDistance(
                            spot.longitude,
                            spot.latitude,
                            value.longitude,
                            value.latitude
                        )
                        val direction = calcDirection(
                            spot.longitude,
                            spot.latitude,
                            value.longitude,
                            value.latitude
                        )
                        addWiFiSpotButton(
                            spot.id.toInt(),
                            (distance * sin(direction)).toInt(),
                            (distance * cos(direction)).toInt()
                        )
                    }
                    constraintSet.applyTo(constraintLayout)
                }
            )
            it.orientationLiveData.observe(
                this,
                Observer {
//                    constraintSet.applyTo(constraintLayout)
                }
            )
        }

        binding?.let {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }

        return binding?.root
    }

    private fun filterSpotData(location: Location): List<SpotData> {
        val latitudeRange =
            (location.latitude - RADAR_DISPLAY_RANGE)..(location.latitude + RADAR_DISPLAY_RANGE)
        val longitudeRange =
            (location.longitude - RADAR_DISPLAY_RANGE)..(location.longitude + RADAR_DISPLAY_RANGE)
        return viewModel.spotdataList.filter { spot ->
            spot.latitude in latitudeRange &&
            spot.longitude in longitudeRange
        }
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
        binding = null
    }
}
