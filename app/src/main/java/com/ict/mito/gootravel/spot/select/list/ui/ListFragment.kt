package com.ict.mito.gootravel.spot.select.list.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.list_bottomappbar_menu)
            it.setOnMenuItemClickListener { menu ->
                when (menu.itemId) {
                    R.id.appbar_radar -> {
                        findNavController().navigate(R.id.action_listFragment_to_radarFragment)
                    }
                    R.id.appbar_search -> {
                        findNavController().navigate(R.id.action_listFragment_to_searchFragment)
                    }
                    R.id.app_bar_manual -> {
                        startActivity(
                            Intent(
                                context,
                                ManualActivity::class.java
                            )
                        )
                    }
                    R.id.app_bar_language -> {
                        startActivity(
                            Intent(
                                context,
                                SettingActivity::class.java
                            )
                        )
                    }
                }
                true
            }
        }
        return inflater.inflate(
            R.layout.list_fragment,
            container,
            false
        )
    }
}
