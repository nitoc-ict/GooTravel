package com.ict.mito.gootravel.spot.select.radar.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RadarFragmentBinding
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RadarFragment : Fragment() {

    private val viewModel: RadarViewModel by viewModel()
    private var binding: RadarFragmentBinding? = null

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

        viewModel.fragmentManager = fragmentManager!!

        binding?.let {
            it.viewmodel = viewModel
            it.wifiSpot.setOnClickListener { view ->
                viewModel.onClickSpot(view)
            }
            it.foodSpot.setOnClickListener { view ->
                viewModel.onClickSpot(view)
            }
            it.shopSpot.setOnClickListener { view ->
                viewModel.onClickSpot(view)
            }
            it.lifecycleOwner = this
        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
