package com.ict.mito.gootravel.spot.register.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-10-03.
 */
class RegisterSpotListAdapter(private val registerSpotList: List<RegisterPointData>) :
    RecyclerView.Adapter<RegisterSpotListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RegisterSpotListViewHolder = RegisterSpotListViewHolder.create(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun getItemCount(): Int = registerSpotList.size

    override fun onBindViewHolder(
        holder: RegisterSpotListViewHolder,
        position: Int
    ) {
        holder.bind(registerSpotList[position])
    }
}
