package com.ict.mito.gootravel.setting.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.setting.language.ui.CustomAdapter
import com.ict.mito.gootravel.setting.language.ui.language

class SettingActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
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
}