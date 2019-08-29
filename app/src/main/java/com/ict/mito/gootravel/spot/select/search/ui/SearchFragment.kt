package com.ict.mito.gootravel.spot.select.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.activity_spot.*
import kotlinx.android.synthetic.main.search_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.search_bottomappbar_menu)
            activity?.bottom_appbar?.setOnMenuItemClickListener { menu ->
                when (menu.itemId) {
                    R.id.appbar_radar -> {
                        findNavController().navigate(R.id.action_searchFragment_to_radarFragment)
                    }
                    R.id.appbar_list -> {
                        findNavController().navigate(R.id.action_searchFragment_to_listFragment)
                    }
                    R.id.app_bar_manual -> {
                    }
                }
                true
            }
        }
        return inflater.inflate(
            R.layout.search_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_to_radar.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_radarFragment)
        }
    }
}
