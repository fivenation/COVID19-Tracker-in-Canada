package com.example.covid_19incanada.Retrofit

import com.example.covid_19incanada.Models.ReportModel
import com.example.covid_19incanada.Models.Summary
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("summary")
    fun getSummary(): Call<Summary>

    @GET("summary/split")
    fun getReports(): Call<ReportModel>

}
