package com.tcoding.countryinformation.DAL

import android.net.ConnectivityManager

object Controls {

    fun internetControl(cm : ConnectivityManager) : Boolean{
        var netInfos = cm.allNetworkInfo

       return true

    }

}