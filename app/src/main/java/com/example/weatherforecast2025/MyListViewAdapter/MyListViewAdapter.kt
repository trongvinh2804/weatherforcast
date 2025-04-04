package com.example.weatherforecast2025.MyListViewAdapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.weatherforecast2025.R
import com.example.weatherforecast2025.databinding.ItemWeatherLayoutBinding
import com.example.weatherforecast2025.models.Weather

class MyListViewAdapter (val context: Activity, val arrKetQua:List<Weather>) : ArrayAdapter<Weather>(context,0,arrKetQua) {
    companion object{
        val RAIN = "Rain"
        val CLOUND = "Clound"
        val CLEAR = "Clear"
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding : ItemWeatherLayoutBinding? = null
        if(convertView == null){
            binding = ItemWeatherLayoutBinding.inflate(LayoutInflater.from(context), parent,false)
        }
        else{
            binding = ItemWeatherLayoutBinding.bind(convertView)
        }
        val ketQua = arrKetQua.get(position)

        if(ketQua.weathers.get(0).thoiTiet == CLEAR){
            binding.imgWeather.setImageResource(R.drawable.clear)
        }
        else if(ketQua.weathers.get(0).thoiTiet == RAIN){
            binding.imgWeather.setImageResource(R.drawable.rain)
        }
        else{
            binding.imgWeather.setImageResource(R.drawable.clounds)
        }

        binding.txtKQNhietDo.setText("Lon nhat: ${String.format("%.0f",ketQua.main.nhietDoLonNhat - 275.15f + 0.5)} do c hien tai ${String.format("%.0f",ketQua.main.nhietDo - 275.15f +0.5)} nhiet do hhien tai ${String.format("%.0f",ketQua.main.nhietDoNhoNhat - 275.15f + 0.5f)}")
        binding.txtKQTocDoGio.text = ketQua.wind.tocDoGio.toString()
        binding.txtKQTamNhin.text = ketQua.tamNhinXa.toString()
        binding.txtKQThoiGian.text = ketQua.thoiGian


        return binding.root
    }
}