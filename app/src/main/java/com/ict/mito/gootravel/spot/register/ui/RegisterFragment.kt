package com.ict.mito.gootravel.spot.register.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.databinding.RegisterFragmentBinding
import com.ict.mito.gootravel.util.READ_REQUEST_CODE
import kotlinx.android.synthetic.main.activity_spot.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class RegisterFragment : Fragment() {

    private val viewmodel: RegisterViewModel by viewModel()
    private var binding: RegisterFragmentBinding? = null

    private val setImageClickListener = View.OnClickListener {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"
        startActivityForResult(
            intent,
            READ_REQUEST_CODE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_fragment,
            container,
            false
        )

        viewmodel.registerPointLiveData.observe(
            this,
            Observer {
                binding?.notifyChange()
            }
        )

        binding?.let {
            it.viewmodel = viewmodel
            it.setImageClickListener = setImageClickListener
            it.lifecycleOwner = this
        }

        return binding?.root
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        resultData: Intent?
    ) {
        if (
            requestCode == READ_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK
        ) {
            val uri: Uri?
            if (resultData != null) {
                uri = resultData.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        context?.contentResolver,
                        uri
                    )
                    viewmodel.setImage(bitmap)
                    binding?.notifyChange()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
