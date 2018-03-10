package com.kadirkuruca.youtubeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyD3_nLo3A14I25cy_0EVI_la9WBrlPuKzY"
    val CHANNEL_ID = "UCv6jcPwFujuTIwFQ11jt1Yw"
    val MAX_RESULTS = 50

    var gelenVeri : PlaylistData? = null
    var oynatmaListeleri : List<PlaylistData.Items> ? = null
    var myAdapter : PlaylistAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface = ApiClient.client?.create(Api_Interface::class.java)
        var apiCall = apiInterface?.tumListeleriGetir(CHANNEL_ID,API_KEY,MAX_RESULTS)

        apiCall?.enqueue(object : Callback<PlaylistData>{

            override fun onResponse(call: Call<PlaylistData>?, response: Response<PlaylistData>?) {
                Log.e("BAŞARILI",call?.request()?.url().toString())

                gelenVeri = response?.body()
                oynatmaListeleri = gelenVeri?.items
                myAdapter = PlaylistAdapter(oynatmaListeleri)
                recylerPlaylist.adapter = myAdapter

                var myLayoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                recylerPlaylist.layoutManager = myLayoutManager

                supportActionBar?.setSubtitle("Toplam Liste : "+oynatmaListeleri?.size)

                //Log.e("BAŞARILI","Toplam liste sayısı : "+oynatmaListeleri?.size)
            }

            override fun onFailure(call: Call<PlaylistData>?, t: Throwable?) {
                Log.e("HATA",""+t?.printStackTrace())
            }

        })




    }
}
