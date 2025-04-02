package com.example.weatherforecast2025.models

import com.google.gson.annotations.SerializedName

class Weather {
    // đọc trực tiếp được
    @SerializedName("visibility")
    var tamNhinXa:Int
    @SerializedName("dt_txt")
    var thoiGian : String

    @SerializedName("main")
    var main:Main

    @SerializedName("wind")
    var wind:Wind

    @SerializedName("weather")
    var weathers : ArrayList<WeatherItem>

    constructor(
        tamNhinXa: Int,
        thoiGian: String,
        main: Main,
        weathers: ArrayList<WeatherItem>,
        wind: Wind
    ) {
        this.tamNhinXa = tamNhinXa
        this.thoiGian = thoiGian
        this.main = main
        this.weathers = weathers
        this.wind = wind
    }

    //dinh nghia cac lop doc du lieu
    class Main{
        @SerializedName("temp")
        var nhietDo : Float

        constructor(nhietDo: Float, nhietDoLonNhat: Float, nhietDoNhoNhat: Float) {
            this.nhietDo = nhietDo
            this.nhietDoLonNhat = nhietDoLonNhat
            this.nhietDoNhoNhat = nhietDoNhoNhat
        }

        @SerializedName("temp_max")
        var nhietDoLonNhat : Float
        @SerializedName("temp_min")
        var nhietDoNhoNhat : Float
    }

    class WeatherItem{
        @SerializedName("main")
        var thoiTiet : String

        constructor(thoiTiet: String) {
            this.thoiTiet = thoiTiet
        }
    }

    class Wind{
        constructor(tocDoGio: Float) {
            this.tocDoGio = tocDoGio
        }

        @SerializedName("speed")
        var tocDoGio : Float
    }
}