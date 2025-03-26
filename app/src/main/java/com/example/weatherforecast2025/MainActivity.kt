package com.example.weatherforecast2025

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherforecast2025.MyListViewAdapter.MyListViewAdapter
import com.example.weatherforecast2025.databinding.WeatherLayoutBinding
import com.example.weatherforecast2025.models.Weather

class MainActivity : AppCompatActivity() {
    private lateinit var binding: WeatherLayoutBinding
    private lateinit var adapter: MyListViewAdapter
    private lateinit var arrWeathers : ArrayList<Weather>
    private lateinit var city: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrSpinner = arrayListOf("HaNoi", "HoChiMinh","DaNang", "Hue", "CanTho")
        val adapterSpinner = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrSpinner)

        // bắt sự kiện cho
        binding.spKhuVuc.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // lấy tên của item người dùng chọn trong
                city = parent?.selectedItem.toString()
                Log.d("test",city)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.spKhuVuc.adapter = adapterSpinner


         arrWeathers = arrayListOf(
            Weather(1,"20 phut",30f, 32f,28f,"Clear",68f),
            Weather(1,"20 phut",30f, 32f,28f,"Cloud",68f)
        )
        adapter = MyListViewAdapter(this,arrWeathers)
        binding.lvKetQua.adapter = adapter
    }

}