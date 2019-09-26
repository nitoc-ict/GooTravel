package com.ict.mito.gootravel.spot.select.list.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R

class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.place_name)
    val distanceView : TextView = itemView.findViewById(R.id.distance)
}