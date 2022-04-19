package com.tcoding.countryinformation.DAL

import android.net.ConnectivityManager

object Controls {

    fun internetControl(cm : ConnectivityManager) : Boolean{
        var netInfos = cm.allNetworkInfo

        netInfos.forEach {
            if(it.type == ConnectivityManager.TYPE_WIFI && it.type == ConnectivityManager.TYPE_MOBILE && it.isConnected) {
                return true
            }
        }

       return false

    }

}