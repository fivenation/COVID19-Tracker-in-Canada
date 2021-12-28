package com.example.covid_19incanada.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19incanada.Models.ReportData
import com.example.covid_19incanada.Models.ReportModel
import com.example.covid_19incanada.R

class ProvinceAdapter(val context: Context?, val arr: List<ReportData>) : RecyclerView.Adapter<ReportHolder>() {
    override fun onBindViewHolder(holder : ReportHolder, current : Int){
        val obj = arr[current]
        holder.province.text = obj.province
        holder.date.text = obj.date
        holder.cases.text = obj.total_cases
        holder.deaths.text = obj.total_fatalities
        holder.hospitalized.text = obj.total_hospitalizations
        holder.recoveries.text = obj.total_recoveries
        holder.tests.text = obj.total_tests

        holder.cases_changed.text = ("(" + (if (obj.change_cases!!.toInt() < 0) "" else "+") + obj.change_cases + ")")
        holder.deaths_changed.text = ("(" + (if (obj.change_fatalities!!.toInt() < 0) "" else "+") + obj.change_fatalities + ")")
        holder.hospitalized_changed.text = ("(" + (if (obj.change_hospitalizations!!.toInt() < 0) "" else "+") + obj.change_hospitalizations + ")")
        holder.recoveries_changed.text = ("(" + (if (obj.change_recoveries!!.toInt() < 0) "" else "+") + obj.change_recoveries + ")")
        holder.tests_changed.text = ("(" + (if (obj.change_tests!!.toInt() < 0) "" else "+") + obj.change_tests + ")")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ReportHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.report_layout, parent, false)
        return ReportHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}

class ReportHolder(reportView: View) : RecyclerView.ViewHolder(reportView) {
    val wrapper: LinearLayout = reportView.findViewById(R.id.rl_wrapper)
    val province: TextView = reportView.findViewById(R.id.rep_province)
    val date: TextView = reportView.findViewById(R.id.rep_date)
    val cases: TextView = reportView.findViewById(R.id.rep_cases)
    val cases_changed: TextView = reportView.findViewById(R.id.rep_cases_changed)
    val deaths: TextView = reportView.findViewById(R.id.rep_deaths)
    val deaths_changed: TextView = reportView.findViewById(R.id.rep_deaths_changed)
    val hospitalized: TextView = reportView.findViewById(R.id.rep_hospitalized)
    val hospitalized_changed: TextView = reportView.findViewById(R.id.rep_hospitalized_changed)
    val recoveries: TextView = reportView.findViewById(R.id.rep_recoveries)
    val recoveries_changed: TextView = reportView.findViewById(R.id.rep_recoveries_changed)
    val tests: TextView = reportView.findViewById(R.id.rep_tests)
    val tests_changed: TextView = reportView.findViewById(R.id.rep_tests_changed)
}