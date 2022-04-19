package com.tcoding.countryinformation

import com.google.gson.annotations.SerializedName

class Deneme : ArrayList<Deneme.DenemeItem>(){
    data class DenemeItem(
        val name : Name,
        val capital : List<String>,
        val borders : List<String>? = null,
        val population : String,
        val flags: Flags
        )

    data class Name(
        var common : String? = null
    )

    data class Flags(
        var png : String,
        var svg : String,
    )



}