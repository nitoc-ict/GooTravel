package com.ict.mito.gootravel.setting.language.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R

class CustomAdapter(val languageList: ArrayList<language>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(languageList[position])
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(language: language) {
            val textViewName = itemView.findViewById(R.id.textViewlanguage) as TextView
            textViewName.text = language.name
        }
    }
}