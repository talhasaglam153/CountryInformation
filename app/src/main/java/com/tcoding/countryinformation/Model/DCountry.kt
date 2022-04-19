package com.tcoding.countryinformation.Model

import com.google.gson.annotations.SerializedName

class DCountry : ArrayList<DCountry.CountryItem>(){
    data class CountryItem(
        val altSpellings: List<String>,
        val area: Double,
        val capital: List<String>?,
        val cca2: String,
        val cca3: String,
        val ccn3: String,
        val cioc: String,
        val currencies: Currencies,
        val flag: String,
        val flags: Flags,
        val independent: Boolean,
        val languages: Languages,
        val name: Name,
        val population: Int,
        val region: String,
        val status: String,
        val unMember: Boolean
    ) {
        data class Currencies(
            @SerializedName("TRY")
            val tl : TRY
        ) {
            data class TRY(
                val name: String,
                val symbol: String
            )
        }

        data class Flags(
            val png: String,
            val svg: String
        )

        data class Languages(
            val tur: String?
        )

        data class Name(
            val common: String,
            val nativeName: NativeName,
            val official: String
        ) {
            data class NativeName(
                val tur: Tur
            ) {
                data class Tur(
                    val common: String,
                    val official: String
                )
            }
        }
    }
}