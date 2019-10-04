package com.ict.mito.gootravel.spot.register.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterSpotListFragmentBinding
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterSpotListFragment : Fragment() {
    private val viewmodel: RegisterSpotListViewModel by viewModel()
    private var binding: RegisterSpotListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_spot_list_fragment,
            container,
            false
        )

        viewmodel.also {
            it.navController = findNavController()
            it.registerSpotListLiveData.observe(
                this,
                Observer { list ->
                    it.adapter.setSpotList(list)
                }
            )
        }
        binding?.let {
            it.viewmodel = viewmodel
            it.lifecycleOwner = this
        }

        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        activity?.bottom_appbar?.replaceMenu(R.menu.empty_menu)

        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.supportActionBar?.let {
            it.title = getString(R.string.register_fragment_title)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        }
    }
}
