package com.ict.mito.gootravel.wifi.connect.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.ict.mito.gootravel.R

class ConnectDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("SSID")
            .setMessage("massage")
            .setPositiveButton(getString(R.string.connect)) { _, _ -> }
            .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
        return builder.create()
    }
}