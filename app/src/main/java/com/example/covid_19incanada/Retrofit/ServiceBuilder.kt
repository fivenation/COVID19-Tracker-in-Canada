package com.example.covid_19incanada.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.reflect.KClass

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19tracker.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}
