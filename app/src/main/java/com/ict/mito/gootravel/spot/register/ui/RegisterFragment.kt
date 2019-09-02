package com.ict.mito.gootravel.spot.register.ui

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.ict.mito.gootravel.R
import kotlinx.android.synthetic.main.register_fragment.*

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel

        super.onCreate(savedInstanceState)

        SignIn.setOnClickListener{
            var name: String = Name.text.toString()
            var memo: String = Memo.text.toString()

            if(Name.length() != 0 && Memo.length() != 0){

                Log.d("memo", memo)
                Log.d("name", name)
                Name.setText("")
                Memo.setText("")
                val toast = Toast.makeText(context, "入力が完了しました", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }


}