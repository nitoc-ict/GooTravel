package com.ict.mito.gootravel.disaster.notification.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
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
            builder.setTitle("Earthquake")
                .setMessage("massage")
                .setIcon(R.drawable.error)
                .setPositiveButton("REFUGE", object: DialogInterface.OnClickListener {
                    override fun onClick(dialog:DialogInterface, id:Int) {}
                })
                .setNegativeButton("MANUAL", object: DialogInterface.OnClickListener {
                    override fun onClick(dialog:DialogInterface, id:Int) {}
                })
            return builder.create()
        }
    }
}