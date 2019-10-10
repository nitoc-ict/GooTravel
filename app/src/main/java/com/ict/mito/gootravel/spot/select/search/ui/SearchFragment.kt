package com.ict.mito.gootravel.spot.select.search.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    private val onMenuItemClickListener = Toolbar.OnMenuItemClickListener { menu ->
        when (menu.itemId) {
            R.id.appbar_radar -> {
                findNavController().navigate(R.id.action_searchFragment_to_radarFragment)
            }
            R.id.appbar_list -> {
                findNavController().navigate(R.id.action_searchFragment_to_listFragment)
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
            R.id.app_bar_register -> {
                findNavController().navigate(
                    R.id.action_searchFragment_to_registerSpotListFragment
                )
            }
        }
        true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.bottom_appbar?.replaceMenu(R.menu.search_bottomappbar_menu)

        return inflater.inflate(
            R.layout.search_fragment,
            container,
            false
        )
    }
}
