package com.ict.mito.gootravel.setting.language.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R

class LanguageSettingAdapter(
    val languageList: List<Language>
) : RecyclerView.Adapter<LanguageSettingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LanguageSettingAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.list_layout,
            parent,
            false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: LanguageSettingAdapter.ViewHolder,
        position: Int
    ) {
        holder.bindItems(languageList[position])
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(language: Language) {
            val textViewName = view.findViewById(R.id.textView_language) as TextView
            textViewName.text = language.name
        }
    }
}