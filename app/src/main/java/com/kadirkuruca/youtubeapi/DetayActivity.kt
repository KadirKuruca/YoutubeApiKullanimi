package com.kadirkuruca.youtubeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyD3_nLo3A14I25cy_0EVI_la9WBrlPuKzY"
    val CHANNEL_ID = "UCv6jcPwFujuTIwFQ11jt1Yw"
    val MAX_RESULTS = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelen = intent

        if(gelen != null){

            tvAd.setText(gelen.getStringExtra("ad"))
            Toast.makeText(this,"Id : "+gelen.getStringExtra("playlistId"), Toast.LENGTH_LONG).show()
        }
    }
}
