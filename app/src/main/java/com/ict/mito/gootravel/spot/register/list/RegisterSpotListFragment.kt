package com.ict.mito.gootravel.spot.register.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterSpotListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterSpotListFragment : Fragment() {
    private val viewmodel: RegisterSpotListViewModel by viewModel()
    private var binding: RegisterSpotListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_spot_list_fragment,
            container,
            false
        )

        return binding?.root
    }
}
