package com.tcoding.countryinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson

import com.tcoding.countryinformation.DAL.WebServicesAsync
import com.tcoding.countryinformation.Model.Country
import com.tcoding.countryinformation.Model.DCountry
import com.tcoding.countryinformation.View.Adapter.CountryAdapter
import com.tcoding.countryinformation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var countryList : ArrayList<Country>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countryList = ArrayList<Country>()
        init()
        pullData()
        Toast.makeText(this,"Veri sayisi :${countryList.size}",Toast.LENGTH_SHORT).show()
    }

    fun init() {
        countryList = ArrayList<Country>()
        var lm = LinearLayoutManager(this)
        lm.orientation = LinearLayoutManager.VERTICAL
        binding.rv.layoutManager = lm
        Toast.makeText(this,"Başladı",Toast.LENGTH_SHORT).show()

        binding.rv.adapter = CountryAdapter(this, countryList)
    }


    fun pullData() {
        val url = "https://restcountries.com/v3.1/all"
        WebServicesAsync(this, url, ::resultFunc).execute()
    }

    fun resultFunc(code : Int, message: String) {
        var borders: String = ""

        if(code == 200) {
            val gson = Gson()
            val resultData = gson.fromJson(message, DCountry::class.java)

            resultData.forEach {
                borders = ""
                it.borders?.forEach {
                    borders = it + "," + borders
                }

                countryList.add(Country(
                    it.flags.png,
                    it.name.common,
                    it.capital?.get(0),
                    it.population,
                    borders
                ))
            }
            binding.rv.adapter = CountryAdapter(this, countryList)
            binding.progressBar.visibility = View.GONE

        }else if(code == 0){
            Toast.makeText(this, "Lütfen internet bağlantınız kontrol ediniz", Toast.LENGTH_SHORT).show()
        }


    }
}