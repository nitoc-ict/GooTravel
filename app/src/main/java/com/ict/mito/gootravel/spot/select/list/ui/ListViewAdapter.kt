package com.ict.mito.gootravel.spot.select.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R
import com.xwray.groupie.ViewHolder

class ListViewAdapter(private val list : List<ListRowItemx>, private val listener : ListListener) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val rowView : View = LayoutInflater.from(parent.context).inflate(R.layout.list_row_item, parent, false)
        return ListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.titleView.text = list[position].place_name
        holder.distanceView.text = list[position].distance
        //ImageViewは保留
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ListListener {
        fun onClickRow(tappedView : View, rowItem : ListRowItemx)
    }
}