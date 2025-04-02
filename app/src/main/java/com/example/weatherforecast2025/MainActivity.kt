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
import com.example.weatherforecast2025.models.WeatherAPI
import com.example.weatherforecast2025.models.WeatherList
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding: WeatherLayoutBinding
    private lateinit var adapter: MyListViewAdapter
    private lateinit var arrWeathers : ArrayList<Weather>
    private lateinit var city: String
    private val key = "bb115812548f62070da628d7debb2952"
    private lateinit var weatherAPI : WeatherAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrSpinner = arrayListOf("HaNoi", "Ho Chi Minh","DaNang", "Hue", "CanTho")
        val adapterSpinner = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrSpinner)

        arrWeathers = arrayListOf()
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
                //Log.d("test",city)

                // cap nhat lai du lieu thoi thiet cho thanh pho duco chon
                getWeathers(city,arrWeathers)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spKhuVuc.adapter = adapterSpinner
        adapter = MyListViewAdapter(this,arrWeathers)
        binding.lvKetQua.adapter = adapter


    }
// xay dung ham tra ve
        private fun getWeathers(city:String, list: ArrayList<Weather>) {
        // b1 xóa dữ liệu cũ
        arrWeathers.clear()
        // b2 tao doi tuong Retrofig
        val retrofig = Retrofit.Builder()
            .baseUrl(WeatherAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //b3 tao doi tuong WeatherAPI
        weatherAPI = retrofig.create(WeatherAPI::class.java)
        //b4 yeu cau doc du lieu tu web ve
        val call = weatherAPI.getDataWeathers(city, key)
        call.enqueue(object : Callback<WeatherList>{
            override fun onResponse(call: Call<WeatherList>, result: Response<WeatherList>) {
                //kiem tra ket qua tra ve
                if(result.isSuccessful){
                    // su ly du lieu tra ve
                    val weatherList = result.body()
                    weatherList?.list?.let {
                        list.addAll(it)
                    }
                    //bao cho lisst view cap nhat du lieu moi
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(p0: Call<WeatherList>, p1: Throwable) {}

        })
    }
}