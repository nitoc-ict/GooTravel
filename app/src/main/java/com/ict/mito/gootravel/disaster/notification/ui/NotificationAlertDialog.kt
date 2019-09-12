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
