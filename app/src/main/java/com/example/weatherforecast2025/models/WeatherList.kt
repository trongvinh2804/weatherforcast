package com.example.weatherforecast2025.models

import com.google.gson.annotations.SerializedName

class WeatherList {
    @SerializedName("list")
    lateinit var list : ArrayList<Weather>
}