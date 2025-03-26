package com.example.weatherforecast2025.models

class Weather {
    var tamNhinXa:Int
    var thoiGian : String
    var nhietDo : Float
    var nhietDoLonNhat : Float
    var nhietDoNhoNhat : Float
    var thoiTiet : String
    var tocDoGio : Float

    constructor(
        tamNhinXa:Int,
        thoiGian : String,
        nhietDo : Float,
        nhietDoLonNhat : Float,
        nhietDoNhoNhat : Float,
        thoiTiet : String,
        tocDoGio : Float,
    ){
        this.tamNhinXa = tamNhinXa
        this.thoiGian = thoiGian
        this.nhietDo = nhietDo
        this.nhietDoLonNhat = nhietDoLonNhat
        this.nhietDoNhoNhat = nhietDoNhoNhat
        this.thoiTiet = thoiTiet
        this.tocDoGio = tocDoGio
    }
}