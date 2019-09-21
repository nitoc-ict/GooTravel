package com.ict.mito.gootravel.spot.register.ui

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.register_fragment.*
import java.io.IOException
import java.text.DateFormat
import java.util.*
import kotlin.coroutines.coroutineContext

class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment,
            container,
            false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel

        super.onCreate(savedInstanceState)

        register.setOnClickListener {
            val name: String = name_input.text.toString()
            val memo: String = memo_input.text.toString()

            if (name_input.length() != 0 && memo_input.length() != 0) {

                Log.d("memo", memo)
                Log.d("name", name)
                name_input.setText("")
                memo_input.setText("")
                Toast.makeText(context, "入力が完了しました", Toast.LENGTH_SHORT).show()
            }
        }

        time_pick.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val minute = calendar.get(Calendar.MINUTE)
                val dialog = TimePickerDialog(
                    context,
                    object : TimePickerDialog.OnTimeSetListener {
                        override fun onTimeSet(view: TimePicker,
                                               hourOfDay: Int,
                                               minute: Int) {}
                    },
                    hour, minute, true
                )
                dialog.show()
            }
        })

         val READ_REQUEST_CODE = 42

        image_input.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.setType("image/*")
                startActivityForResult(intent, READ_REQUEST_CODE)
            }
        })
    }

    val READ_REQUEST_CODE = 42

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  resultData: Intent?) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) { val uri: Uri?
            if (resultData != null) { uri = resultData.getData()
                try { val bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, uri)
                    image_view.setImageBitmap(bitmap)
                } catch (e: IOException) { e.printStackTrace()
                }
            }
        }
    }
}



