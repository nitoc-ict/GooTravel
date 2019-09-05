package com.ict.mito.gootravel.spot.select.radar.ui.dailog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.SelectSpotPopupBinding

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheet : BottomSheetDialogFragment() {
    private var binding: SelectSpotPopupBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_spot_popup,
            container,
            false
        )

        val id: Int = arguments?.getInt("spotId") ?: 0

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}