package com.ict.mito.gootravel.spot.select.radar.ui.dailog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ict.mito.gootravel.R

/**
 * Created by mitohato14 on 2019-09-05.
 */
class SelectSpotBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.select_spot_popup,
            container,
            false
        )
    }
}