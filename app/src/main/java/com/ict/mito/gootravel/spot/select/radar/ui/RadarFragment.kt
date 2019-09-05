package com.ict.mito.gootravel.spot.select.radar.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RadarFragmentBinding
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.spot.select.radar.ui.dailog.SelectSpotBottomSheet
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RadarFragment : Fragment() {

    private val viewModel: RadarViewModel by viewModel()
    private var binding: RadarFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.radar_bottomappbar_menu)
            activity?.bottom_appbar?.setOnMenuItemClickListener { menu ->
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
                    else -> {
                        findNavController().navigate(R.id.action_radarFragment_to_registerFragment)
                    }
                }
                true
            }
        }

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.radar_fragment,
            container,
            false
        )

//        binding?.viewmodel = viewModel
        binding?.wifiSpot?.setOnClickListener {
            val args = Bundle()
            args.putInt(
                "spotId",
                it.id
            )
            val bottomSheet = SelectSpotBottomSheet()
            bottomSheet.arguments = args
            bottomSheet.show(
                fragmentManager!!,
                bottomSheet.tag
            )
        }
        binding?.foodSpot?.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_navigateFragment)
        }
        binding?.shopSpot?.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_navigateFragment)
        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
