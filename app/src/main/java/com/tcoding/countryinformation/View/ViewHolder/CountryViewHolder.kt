package com.tcoding.countryinformation.View.ViewHolder

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
    var tv_languages: TextView
    var tv_currency: TextView

    init {
        iv_countryFlag = itemView.findViewById(R.id.iv_countryFlag)
        tv_countryName = itemView.findViewById(R.id.tv_countryName)
        tv_capital = itemView.findViewById(R.id.tv_capital)
        tv_population = itemView.findViewById(R.id.tv_population)
        tv_languages = itemView.findViewById(R.id.tv_languages)
        tv_currency = itemView.findViewById(R.id.tv_currency)
    }

    fun bindData(country: Country) {
        Glide.with(context).load(country.flag).into(iv_countryFlag)
        tv_countryName.setText(country.name)
        tv_capital.setText(country.capital)
        tv_population.setText(country.population)
        tv_languages.setText(country.language)
        tv_currency.setText(country.currency)

    }



}