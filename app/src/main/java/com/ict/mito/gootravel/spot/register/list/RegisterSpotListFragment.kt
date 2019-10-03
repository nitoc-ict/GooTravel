package com.ict.mito.gootravel.spot.register.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ict.mito.gootravel.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterSpotListFragment : Fragment() {
    private val viewmodel: RegisterSpotListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_spot_list_fragment, container, false)
    }
}
