package com.ict.mito.gootravel.setting.language.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R


class LanguageSettingFragment : Fragment() {

    private lateinit var viewModel: LanguageSettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        fun setContentView(languageSettingFragment: Int) {


        }

        fun findViewById(recyclerView: Int) {


        }

        fun LinearLayoutManager(
            languageSettingFragment: LanguageSettingFragment,
            vertical: Int,
            b: Boolean
        ) {


        }

        @SuppressLint("WrongConstant")
        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.language_setting_fragment)

            val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

            val languages = ArrayList<language>()

            languages.add(language("英語"))
            languages.add(language("中国語(繫体字)"))
            languages.add(language("中国語(簡体字)"))
            languages.add(language("韓国語"))

            val adapter = CustomAdapter(languages)

            recyclerView.adapter = adapter
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            viewModel = ViewModelProviders.of(this).get(LanguageSettingViewModel::class.java)
            // TODO: Use the ViewModel

        }
    }
}
