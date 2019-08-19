package com.ict.mito.gootravel.util

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

/**
 * Created by mitohato14 on 2019-08-19.
 */
class LocationRequestAlertDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setTitle("")
            .setMessage("")
            .setPositiveButton("") { _, _ ->
                activity?.finish()
            }
            .create()
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }
}