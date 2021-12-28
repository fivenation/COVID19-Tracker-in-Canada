package com.example.covid_19incanada.fragments

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19incanada.R
import com.example.covid_19incanada.Retrofit.RequestManager
import kotlinx.android.synthetic.main.fragment_byprovince.*

class ProvinceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_byprovince, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter : ProvinceAdapter?

        rv_recyclerView.layoutManager = LinearLayoutManager(context)

        val apiService = RequestManager()
        apiService.getReports {
            this.progress_circular_reports.visibility = ProgressBar.VISIBLE
            if (it == null) {
                this.progress_circular_reports.visibility = ProgressBar.GONE
                val toast = Toast.makeText(activity, "Connection error!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 50)
                toast.show()
            } else {
                adapter = ProvinceAdapter(context, it.data)
                rv_recyclerView.adapter = adapter
                this.progress_circular_reports.visibility = ProgressBar.GONE
                this.rv_recyclerView.visibility = ProgressBar.VISIBLE
            }

        }

    }

    companion object {
        @JvmStatic
        fun newInstance() : ProvinceFragment {
            return ProvinceFragment()
        }
    }
}