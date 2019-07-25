package com.ict.mito.gootravel.spot.select.radar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.radar_fragment.*

class RadarFragment : Fragment() {

    companion object {
        fun newInstance() = RadarFragment()
    }

    private lateinit var viewModel: RadarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.radar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RadarViewModel::class.java)
        // TODO: Use the ViewModel
        button_to_list.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_listFragment)
        }
        button_to_search.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_searchFragment)
        }
        button_to_navigate.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_navigateFragment)
        }
        button_to_register.setOnClickListener {
            findNavController().navigate(R.id.action_radarFragment_to_registerFragment)
        }
    }

}
