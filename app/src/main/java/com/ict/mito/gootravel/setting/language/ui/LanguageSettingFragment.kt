package com.ict.mito.gootravel.setting.language.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R


class LanguageSettingFragment : Fragment() {

    private lateinit var viewModel: LanguageSettingViewModel

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
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        val languages = ArrayList<language>()

        languages.add(language("英語"))
        languages.add(language("中国語(繫体字)"))
        languages.add(language("中国語(簡体字)"))
        languages.add(language("韓国語"))

        val adapter = CustomAdapter(languages)

        recyclerView.adapter = adapter
        return view
    }

    private fun findViewById(recyclerView: Int) {


    }
}