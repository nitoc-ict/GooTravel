package com.ict.mito.gootravel.spot.navigate.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ict.mito.gootravel.R

class NavigateFragment : Fragment() {

    companion object {
        fun newInstance() = NavigateFragment()
    }

    private lateinit var viewModel: NavigateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.navigate_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NavigateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
