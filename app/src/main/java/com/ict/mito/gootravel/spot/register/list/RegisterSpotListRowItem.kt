package com.ict.mito.gootravel.spot.register.list

import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterSpotListRowBinding
import com.ict.mito.gootravel.spot.model.RegisterPointData
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by mitohato14 on 2019-10-05.
 */
class RegisterSpotListRowItem(val registerSpotData: RegisterPointData) :
    BindableItem<RegisterSpotListRowBinding>() {
    override fun getLayout(): Int = R.layout.register_spot_list_row

    override fun bind(viewBinding: RegisterSpotListRowBinding, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}