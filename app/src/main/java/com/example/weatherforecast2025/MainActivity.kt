package com.example.weatherforecast2025

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherforecast2025.MyListViewAdapter.MyListViewAdapter
import com.example.weatherforecast2025.databinding.WeatherLayoutBinding
import com.example.weatherforecast2025.models.Weather

class MainActivity : AppCompatActivity() {
    private lateinit var binding: WeatherLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrSpinner = arrayListOf("HaNoi", "HoChiMinh")
        val adapterSpinner = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrSpinner)
        binding.spKhuVuc.adapter = adapterSpinner
        val arrWeathers = arrayListOf(
            Weather(1,"20 phut",30f, 32f,28f,"Clear",68f),
            Weather(1,"20 phut",30f, 32f,28f,"Cloud",68f)
        )
        var adapter = MyListViewAdapter(this,arrWeathers)
        binding.lvKetQua.adapter = adapter
    }

}