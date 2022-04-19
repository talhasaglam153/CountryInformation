package com.tcoding.countryinformation.View.ViewHolder

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tcoding.countryinformation.Model.Country
import com.tcoding.countryinformation.R

class CountryViewHolder(var context : Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

    var iv_countryFlag: ImageView
    var tv_countryName: TextView
    var tv_capital: TextView
    var tv_population: TextView
    var tv_borders: TextView

    init {
        iv_countryFlag = itemView.findViewById(R.id.iv_countryFlag)
        tv_countryName = itemView.findViewById(R.id.tv_countryName)
        tv_capital = itemView.findViewById(R.id.tv_capital)
        tv_population = itemView.findViewById(R.id.tv_population)
        tv_borders = itemView.findViewById(R.id.tv_borders)
    }

    @SuppressLint("SetTextI18n")
    fun bindData(country: Country) {
        Glide.with(context).load(country.flag).into(iv_countryFlag)
        tv_countryName.setText(country.name)
        tv_capital.setText(country.capital)
        tv_population.setText(country.population)
        if(country.borders.equals("")) {
            country.borders = "Island Country"
        }else{
            country.borders = "${country.borders}"
        }
        tv_borders.setText(country.borders)

    }



}