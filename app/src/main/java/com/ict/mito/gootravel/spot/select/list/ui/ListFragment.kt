package com.ict.mito.gootravel.spot.select.list.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ict.mito.gootravel.R
import com.ict.mito.gootravel.disaster.manual.ui.ManualActivity
import kotlinx.android.synthetic.main.activity_spot.*
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.bottom_appbar?.let {
            it.replaceMenu(R.menu.list_bottomappbar_menu)
            it.setOnMenuItemClickListener { menu ->
                when (menu.itemId) {
                    R.id.appbar_radar -> {
                        findNavController().navigate(R.id.action_listFragment_to_radarFragment)
                    }
                    R.id.appbar_search -> {
                        findNavController().navigate(R.id.action_listFragment_to_searchFragment)
                    }
                    R.id.app_bar_manual -> {
                        startActivity(
                            Intent(
                                context,
                                ManualActivity::class.java
                            )
                        )
                    }
                }
                true
            }
        }

        val view = inflater.inflate(
            R.layout.list_fragment,
            container,
            false
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.spot_list_view)
        val adapter = ListViewAdapter(createDataList(), object : ListViewAdapter.ListListener {
            override fun onClickRow(tappedView : View, rowItem : ListRowItemx) {
                this@ListFragment.onClickRow(tappedView, rowItem)
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)


        return view
    }

    private fun createDataList(): List<ListRowItemx> {

        val dataList = mutableListOf<ListRowItemx>()
        for (i in 0..49) {
            val data: ListRowItemx = ListRowItemx("" + i + "番目の場所", "" + i + "m", "")
            dataList.add(data)
        }
        return dataList
    }

    fun onClickRow(tappedView : View, rowItem : ListRowItemx) {
        Snackbar.make(tappedView, "tapped ${rowItem.place_name}", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }
}
