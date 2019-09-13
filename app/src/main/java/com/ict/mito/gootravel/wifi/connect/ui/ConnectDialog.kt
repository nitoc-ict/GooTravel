package com.ict.mito.gootravel.wifi.connect.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConnectDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("SSID")
            .setMessage("massage")
            .setPositiveButton("CONNECT", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, id: Int) {}
            })
            .setNegativeButton("CANCEL", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, id: Int) {}
            })
        return builder.create()
    }
}