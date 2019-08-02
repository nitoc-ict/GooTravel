package com.ict.mito.gootravel.disaster.manual.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ict.mito.gootravel.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ManualFragment : Fragment() {

    private val viewModel: ManualViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.manual_fragment,
            container,
            false
        )
    }
}
