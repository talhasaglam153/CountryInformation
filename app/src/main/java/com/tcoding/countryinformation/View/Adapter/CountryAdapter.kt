package com.tcoding.countryinformation.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tcoding.countryinformation.Model.Country
import com.tcoding.countryinformation.R
import com.tcoding.countryinformation.View.ViewHolder.CountryViewHolder

class CountryAdapter(var context : Context, var countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false)
        return CountryViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindData(countryList.get(position))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}