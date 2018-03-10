package com.kadirkuruca.youtubeapi

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

/**
 * Created by Kadir on 9.03.2018.
 */
class PlaylistAdapter(tumOynatmaListeleri : List<PlaylistData.Items>?) : RecyclerView.Adapter<PlaylistAdapter.PlaylistAdapterViewHolder>() {

    var oynatmaListeleri = tumOynatmaListeleri

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlaylistAdapterViewHolder {

        var inflater = LayoutInflater.from(parent?.context)
        var tekSatirPlaylist = inflater.inflate(R.layout.tek_satir_playlist,parent,false)

        return PlaylistAdapterViewHolder(tekSatirPlaylist)
    }

    override fun onBindViewHolder(holder: PlaylistAdapterViewHolder?, position: Int) {

        var olusturulanListe = oynatmaListeleri?.get(position)
        holder?.setData(position,olusturulanListe)
    }

    override fun getItemCount(): Int {
        return oynatmaListeleri!!.size
    }

    inner class PlaylistAdapterViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

        var tek_satir = itemView as CardView
        var playlistTitle = tek_satir.tvBaslik
        var playlistImage = tek_satir.imgPlaylist

        fun setData(position : Int, olusturulanListe : PlaylistData.Items?){

            playlistTitle.setText(olusturulanListe?.snippet?.title)
            Picasso.with(tek_satir.context).load(olusturulanListe?.snippet?.thumbnails?.high?.url).into(playlistImage)

            tek_satir.setOnClickListener { v->

                var intent = Intent(v.context,DetayActivity::class.java)
                intent.putExtra("ad",olusturulanListe?.snippet?.title)
                intent.putExtra("playlistId",""+ olusturulanListe?.id)
                v.context.startActivity(intent)
            }
        }

    }

}


