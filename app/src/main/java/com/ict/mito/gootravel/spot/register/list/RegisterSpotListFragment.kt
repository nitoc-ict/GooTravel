package com.ict.mito.gootravel.spot.register.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterSpotListFragmentBinding
import com.ict.mito.gootravel.spot.model.SpotFragmentType
import com.ict.mito.gootravel.spot.model.SpotSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterSpotListFragment : Fragment() {
    private val viewmodel: RegisterSpotListViewModel by viewModel()
    private val sharedViewModel: SpotSharedViewModel by sharedViewModel()
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
            it.rowBindableItemList.observe(
                this,
                Observer {
                    viewmodel.groupAdapter.update(it)
                    binding?.notifyChange()
                }
            )
            it.locationLiveData.observe(
                this,
                Observer { _ ->
                    it.update()
                }
            )
        }

        sharedViewModel.fragmentType.postValue(SpotFragmentType.REGISTER_LIST)

        binding?.let {
            it.viewmodel = viewmodel
            it.lifecycleOwner = this
        }

        return binding?.root
    }
}
