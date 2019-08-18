package com.ict.mito.gootravel.spot.select.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.activity_spot.*
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.list_bottomappbar_menu)
            it.setOnMenuItemClickListener { menu ->
                when (menu.itemId) {
                    R.id.appbar_radar -> {
                        findNavController().navigate(R.id.action_listFragment_to_radarFragment)
                    }
                    R.id.appbar_search -> {
                        findNavController().navigate(R.id.action_listFragment_to_searchFragment)
                    }
                }
                true
            }
        }
        return inflater.inflate(
            R.layout.list_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_to_radar.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_radarFragment)
        }
        button_to_search.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_searchFragment)
        }
        button_to_navigate.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_navigateFragment)
        }
        button_to_register.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_registerFragment)
        }
    }
}
