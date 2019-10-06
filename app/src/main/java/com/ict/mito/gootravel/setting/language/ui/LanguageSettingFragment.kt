package com.ict.mito.gootravel.setting.language.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R


class LanguageSettingFragment : Fragment() {

    private lateinit var viewmodel: LanguageSettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.language_setting_fragment,
            container,
            false
        )
        val recyclerView =view.findViewById(R.id.recyclerView) as RecyclerView

        val languages = ArrayList<Language>()

        languages.add(Language(getString(R.string.eigo)))
        languages.add(Language(getString(R.string.hantaiji)))
        languages.add(Language(getString(R.string.kantaiji)))
        languages.add(Language(getString(R.string.kankokugo)))

        val adapter = CustomAdapter(languages)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
}