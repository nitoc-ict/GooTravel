package com.ict.mito.gootravel.spot.register.ui

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.register_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException
import java.util.*

class RegisterFragment : Fragment() {

    private val viewmodel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.register_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        done_button.setOnClickListener {
            var name: String = name_input.text.toString()
            var memo: String = memo_input.text.toString()

            if (name_input.length() != 0 && memo_input.length() != 0) {

                name_input.setText("")
                memo_input.setText("")
            }
        }

        set_notification_button.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val dialog = TimePickerDialog(
                context,
                TimePickerDialog.OnTimeSetListener { _, _, _ -> },
                hour,
                minute,
                true
            )
            dialog.show()
        }

        val READ_REQUEST_CODE = 42

        set_image_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, READ_REQUEST_CODE)
        }
    }

    val READ_REQUEST_CODE = 42

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
                uri = resultData.getData()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        context?.contentResolver,
                        uri
                    )
                    set_image_preview.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}



