package com.tcoding.countryinformation

class DCountry : ArrayList<DCountry.DenemeItem>(){
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