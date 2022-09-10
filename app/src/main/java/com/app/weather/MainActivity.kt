package com.app.weather

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.app.weather.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "7c6d391f52a34bdbb15175839221009"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener{
        getResult("London")
        }
    }
    private fun getResult(name: String){
        val url = "http://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY" +
                "&q=$name&aqi=no"

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                    response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog", "Volley error: $it")

            }
            )

        queue.add(stringRequest)
    }
}



//api    7c6d391f52a34bdbb15175839221009