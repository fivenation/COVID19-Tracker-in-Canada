package com.example.covid_19incanada.Retrofit

import android.net.ConnectivityManager
import android.widget.Toast
import com.example.covid_19incanada.Models.ReportModel
import com.example.covid_19incanada.Models.Summary
import retrofit2.*


class RequestManager {
    fun getSummary(onResult: (Summary?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RetrofitServices::class.java)
        retrofit.getSummary().enqueue(
            object : Callback<Summary> {
                override fun onFailure(call: Call<Summary>, t: Throwable) {
                    t.printStackTrace()
                    onResult(null)
                }

                override fun onResponse(call: Call<Summary>, response: Response<Summary>) {
                        val summary = response.body()
                        onResult(summary)
                }
            }
        )
    }

    fun getReports(onResult: (ReportModel?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RetrofitServices::class.java)
        retrofit.getReports().enqueue(
                object : Callback<ReportModel> {
                    override fun onResponse(call: Call<ReportModel>, response: Response<ReportModel>) {
                        val reports = response.body()
                        onResult(reports)
                    }

                    override fun onFailure(call: Call<ReportModel>, t: Throwable) {
                        t.printStackTrace()
                        onResult(null)
                    }
                }
        )
    }

}