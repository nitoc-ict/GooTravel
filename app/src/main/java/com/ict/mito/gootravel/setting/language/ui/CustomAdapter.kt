package com.ict.mito.gootravel.setting.language.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R

class CustomAdapter(val LanguageList: ArrayList<Language>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomAdapter.
    ViewHolder {
        val v = LayoutInflater.from(parent.context).
            inflate(
            R.layout.list_layout,
            parent,
            false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: CustomAdapter.ViewHolder,
        position: Int
    ) {
        holder.bindItems(LanguageList[position])
    }

    override fun getItemCount(): Int {
        return LanguageList.size
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(language: Language) {
            val textViewName = view.findViewById(R.id.textViewlanguage) as TextView
            textViewName.text = language.name
        }
    }
}