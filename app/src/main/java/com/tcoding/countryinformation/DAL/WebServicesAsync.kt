package com.tcoding.countryinformation.DAL

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask

class WebServicesAsync(
    var context : Context,
    var url : String,
    var resultFunc: (code : Int, message : String) -> Unit
) : AsyncTask<Void, Void, String?>() {

    var resultCode = -1
    var resultMessage = ""
    override fun onPreExecute() {
        super.onPreExecute()
        var cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    }

    override fun doInBackground(vararg p0: Void?): String? {
        TODO("Not yet implemented")
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }
}