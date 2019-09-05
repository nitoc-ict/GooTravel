package com.ict.mito.gootravel.spot.select.radar.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.SelectSpotBottomSheetBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheetFragment : BottomSheetDialogFragment() {
    private var binding: SelectSpotBottomSheetBinding? = null
    private val viewmodel: SelectSpotBottomSheetViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_spot_bottom_sheet,
            container,
            false
        )

        val id: Int = arguments?.getInt("spotId") ?: 0
        viewmodel.setId(id)

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}