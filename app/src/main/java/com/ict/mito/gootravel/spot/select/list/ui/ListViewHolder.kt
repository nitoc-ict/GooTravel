package com.ict.mito.gootravel.spot.select.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.ListRowItemBinding

class ListViewHolder(private val binding: ListRowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val titleView: TextView = itemView.findViewById(R.id.place_name)
    val distanceView: TextView = itemView.findViewById(R.id.distance)

    fun bind(listRowItem: ListRowItem) {
        binding.listrowItem = listRowItem
        binding.executePendingBindings()
    }

    fun unbind() {
        binding.unbind()
    }

    fun setToRootOnClickListener(onClickListener: View.OnClickListener) {
        binding.root.setOnClickListener(onClickListener)
    }

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup,
            attachToRoot: Boolean
        ): ListViewHolder = ListViewHolder(
            ListRowItemBinding.inflate(
                inflater,
                parent,
                attachToRoot
            )
        )
    }
}