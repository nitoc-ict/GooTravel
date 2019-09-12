package com.ict.mito.gootravel.disaster.notification.ui
class NotificationAlertDialog.kt:DialogFragment() {
override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
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
