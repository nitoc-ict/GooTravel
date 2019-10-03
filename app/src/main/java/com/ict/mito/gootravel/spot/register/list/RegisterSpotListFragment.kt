package com.ict.mito.gootravel.spot.register.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ict.mito.gootravel.R

class RegisterSpotListFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterSpotListFragment()
    }

    private lateinit var viewModel: RegisterSpotListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_spot_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterSpotListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
