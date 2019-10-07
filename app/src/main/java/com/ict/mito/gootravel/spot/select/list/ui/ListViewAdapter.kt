package com.ict.mito.gootravel.spot.select.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R

class ListViewAdapter(
    private val list : List<ListRowItem>
) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder = ListViewHolder.create(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        holder.apply {
            bind(list[position])
            setToRootOnClickListener(View.OnClickListener {
                //ここにタップの挙動?

            })
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}