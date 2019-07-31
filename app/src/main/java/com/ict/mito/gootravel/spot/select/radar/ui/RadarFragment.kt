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
import kotlinx.android.synthetic.main.radar_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RadarFragment : Fragment() {

    private val viewModel: RadarViewModel by viewModel()
    private var binding: RadarFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.radar_fragment,
            container,
            false
        )

//        binding?.viewmodel = viewModel
        binding?.wifiSpot?.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_navigateFragment)
        }

        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        button_to_list.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_listFragment)
        }
        button_to_search.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_searchFragment)
        }
        button_to_register.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_registerFragment)
        }
        button_to_manual.setOnClickListener {
            startActivity(Intent(context, ManualActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
