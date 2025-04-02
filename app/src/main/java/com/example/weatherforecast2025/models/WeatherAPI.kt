package com.example.weatherforecast2025.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    companion object{
        const val BASE_URL = "https://api.openweathermap.org/"
    }
    @GET("data/2.5/forecast?")
    fun getDataWeathers(@Query("q") city:String,@Query("appid") key:String) : Call<WeatherList>
}