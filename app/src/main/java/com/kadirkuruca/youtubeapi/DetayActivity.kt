package com.kadirkuruca.youtubeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetayActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyD3_nLo3A14I25cy_0EVI_la9WBrlPuKzY"
    val CHANNEL_ID = "UCv6jcPwFujuTIwFQ11jt1Yw"
    val MAX_RESULTS = 50
    var PLAYLIST_ID : String ? = null
    var gelenVeri : PlaylistVideo? = null
    var videoListesi : List<PlaylistVideo.Items>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelen = intent

        if(gelen != null){

            PLAYLIST_ID = gelen.getStringExtra("playlistId")
        }

        var apiInterface = ApiClient.client?.create(Api_Interface::class.java)
        var apiCall = apiInterface?.videoGetir(PLAYLIST_ID!!,API_KEY,MAX_RESULTS)

        apiCall?.enqueue(object : Callback<PlaylistVideo> {
            override fun onResponse(call: Call<PlaylistVideo>?, response: Response<PlaylistVideo>?) {
                gelenVeri = response?.body()
                videoListesi = gelenVeri?.items
            }

            override fun onFailure(call: Call<PlaylistVideo>?, t: Throwable?) {
                Log.e("HATA",""+t?.printStackTrace())
            }

        })

    }
}
