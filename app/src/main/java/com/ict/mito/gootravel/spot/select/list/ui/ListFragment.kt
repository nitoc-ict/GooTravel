package com.ict.mito.gootravel.spot.select.list.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.ListFragmentBinding
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import com.ict.mito.gootravel.setting.activity.SettingActivity
import com.ict.mito.gootravel.spot.model.SpotFragmentType
import com.ict.mito.gootravel.spot.model.SpotSharedViewModel
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()
    private val sharedViewModel: SpotSharedViewModel by sharedViewModel()
    private var binding: ListFragmentBinding? = null

    private val menuItemClickListener = Toolbar.OnMenuItemClickListener { menu ->
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
            R.id.app_bar_register -> {
                findNavController().navigate(
                    R.id.action_listFragment_to_registerSpotListFragment
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

        activity?.bottom_appbar?.setOnMenuItemClickListener(menuItemClickListener)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_fragment,
            container,
            false
        )

        viewModel.also {
            it.calcSpotDistance()
            it.locationLiveData.observe(
                viewLifecycleOwner,
                Observer { _ ->
                    it.updateDistanceOnce()
                }
            )
            it.rowBindableItem.observe(
                viewLifecycleOwner,
                Observer { list ->
                    it.groupAdapter.update(list)
                    binding?.notifyChange()
                }
            )
            it.navController = findNavController()
        }

        sharedViewModel.fragmentType.postValue(SpotFragmentType.LIST)

        binding?.let {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }

        return binding?.root
    }
}
