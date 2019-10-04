package com.ict.mito.gootravel.spot.register.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.spot.model.RegisterPointData

/**
 * Created by mitohato14 on 2019-10-03.
 */
class RegisterSpotListAdapter(private var registerSpotList: List<RegisterPointData>) :
    RecyclerView.Adapter<RegisterSpotListViewHolder>() {

    lateinit var navController: NavController

    fun setSpotList(spotList: List<RegisterPointData>) {
        registerSpotList = spotList
        notifyDataSetChanged()
    }

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
        holder.apply {
            bind(registerSpotList[position])
            setToRootOnClickListener(View.OnClickListener {
                val action =
                    RegisterSpotListFragmentDirections.actionRegisterSpotListFragmentToRadarFragment(
                        registerSpotList[position].id.toLong()
                    )
                navController.navigate(action)

            })
        }
    }
}
