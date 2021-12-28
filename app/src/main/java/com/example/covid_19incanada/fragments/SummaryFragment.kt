package com.example.covid_19incanada.fragments

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.covid_19incanada.R
import com.example.covid_19incanada.Retrofit.RequestManager
import kotlinx.android.synthetic.main.fragment_summary.*
import java.util.*

class SummaryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = RequestManager()

        apiService.getSummary {
            this.progress_circular.visibility = ProgressBar.VISIBLE

            if (it == null) {
                val toast = Toast.makeText(activity, "Connection error!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 50)
                toast.show()
            } else {
                this.summary_date.text = ("on " + it!!.data[0].latest_date.toString())

                this.cases.text = it.data[0].total_cases.toString()
                this.deaths.text = it.data[0].total_fatalities.toString()
                this.recoveries.text = it.data[0].total_recoveries.toString()
                this.hospitalized.text = it.data[0].total_hospitalizations.toString()
                this.tests.text = it.data[0].total_tests.toString()

                this.cases_changed.text = ("(" + (if (it.data[0].change_cases!!.toInt() < 0) "" else "+") + it.data[0].change_cases.toString() + ")")
                this.deaths_changed.text = ("(" + (if (it.data[0].change_fatalities!!.toInt() < 0) "" else "+") + it.data[0].change_fatalities.toString() + ")")
                this.recoveries_changed.text = ("(" + (if (it.data[0].change_recoveries!!.toInt() < 0) "" else "+") + it.data[0].change_recoveries.toString() + ")")
                this.hospitalized_changed.text = ("(" + (if (it.data[0].change_hospitalizations!!.toInt() < 0) "" else "+") + it.data[0].change_hospitalizations.toString() + ")")
                this.tests_changed.text = ("(" + (if (it.data[0].change_tests!!.toInt() < 0) "" else "+") + it.data[0].change_tests.toString() + ")")

            }
            progress_circular.visibility = ProgressBar.GONE
            cardView.visibility = View.VISIBLE
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() : SummaryFragment {
            return SummaryFragment()
        }
    }



}

