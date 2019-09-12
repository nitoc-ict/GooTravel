package com.ict.mito.gootravel.disaster.notification.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
class MainActivity:AppCompatActivity() {
    protected fun onCreate(savedInstanceState:Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment)
        val newFragment = TestDialogFragment()
        newFragment.show(getSupportFragmentManager(), "test")
    }
    class TestDialogFragment:DialogFragment() {
        fun onCreateDialog(savedInstanceState:Bundle):Dialog {
            val builder = AlertDialog.Builder(getActivity())
            builder.setTitle("SSID")
                    .setMessage("massage")
                    .setPositiveButton("CONNECT", object:DialogInterface.OnClickListener() {
                        fun onClick(dialog:DialogInterface, id:Int) {}
                    })
                    .setNegativeButton("CANCEL", object:DialogInterface.OnClickListener() {
                        fun onClick(dialog:DialogInterface, id:Int) {}
                    })
            return builder.create()
        }
    }
}