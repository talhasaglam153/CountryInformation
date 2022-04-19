package com.tcoding.countryinformation.DAL

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

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

        if(Controls.internetControl(cm)) {
            resultCode = 0
            resultMessage = "Lütfen İnternet Bağlantınızı Kontrol Ediniz"
            resultFunc(resultCode, resultMessage)
            this.cancel(true)
        }


    }

    override fun doInBackground(vararg p0: Void?): String? {
        try {
            val rb = Request.Builder()
            rb.url(url)
            val response = OkHttpClient().newCall(rb.build()).execute()
            if(response != null) {
                if(response.code == 200) {
                    resultCode = 200
                    resultMessage = response.body!!.string()
                }else {
                    resultCode = 2
                }
            }
        }catch (e : IOException) {
            Toast.makeText(context, "Veri Alınamadı", Toast.LENGTH_SHORT).show()
        }

        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        resultFunc(resultCode, resultMessage)

    }

    override fun onCancelled() {
        super.onCancelled()
    }
}