package com.ict.mito.gootravel.spot.register.list

import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.databinding.RegisterSpotListRowBinding
import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-10-03.
 */
class RegisterSpotListViewHolder(private val binding: RegisterSpotListRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(registerPointData: RegisterPointData) {
        binding.also {
            it.registerPoint = registerPointData
            it.notifyChange()
        }
    }
}