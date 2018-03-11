package com.kadirkuruca.youtubeapi

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_videolar.view.*

/**
 * Created by Kadir on 11.03.2018.
 */
class PlaylistVideosAdapter(videoListesi : List<PlaylistVideo.Items>?) : RecyclerView.Adapter<PlaylistVideosAdapter.PlaylistVideosAdapterViewHolder>() {

    var videoListeleri = videoListesi

    override fun onBindViewHolder(holder: PlaylistVideosAdapterViewHolder?, position: Int) {

        var olusturulanVideo = videoListeleri?.get(position)
        holder?.setData(olusturulanVideo,position)
    }

    override fun getItemCount(): Int {

        Log.e("SAYI ",""+videoListeleri!!.size)
        return videoListeleri!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlaylistVideosAdapterViewHolder {

        var inflater = LayoutInflater.from(parent?.context)
        var tek_satir_video = inflater.inflate(R.layout.tek_satir_videolar,parent,false)

        return PlaylistVideosAdapterViewHolder(tek_satir_video)
    }


    inner class PlaylistVideosAdapterViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        var tek_satir = itemView as CardView
        var videoResim = tek_satir.imgVideoResim
        var videoAdi = tek_satir.tvVideoAdi
        var videoSahibi = tek_satir.tvKanalAdi

        fun setData(olusturulanVideo : PlaylistVideo.Items?, position: Int){

            videoAdi.setText(olusturulanVideo?.snippet?.title)
            videoSahibi.setText(olusturulanVideo?.snippet?.channelTitle)

            Picasso.with(tek_satir.context).load(olusturulanVideo?.snippet?.thumbnails?.high?.url).into(videoResim)
        }
    }

}


