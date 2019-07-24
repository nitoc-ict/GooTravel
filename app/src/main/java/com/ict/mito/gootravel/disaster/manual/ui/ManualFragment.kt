package com.ict.mito.gootravel.disaster.manual.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ict.mito.gootravel.R

class ManualFragment : Fragment() {

    companion object {
        fun newInstance() = ManualFragment()
    }

    private lateinit var viewModel: ManualViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manual_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ManualViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
