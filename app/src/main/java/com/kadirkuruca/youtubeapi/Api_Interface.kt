package com.kadirkuruca.youtubeapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kadir on 9.03.2018.
 */
interface Api_Interface {

    //https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCv6jcPwFujuTIwFQ11jt1Yw&maxResults=50&key={YOUR_API_KEY}
    //https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2CcontentDetails%2Cstatus&maxResults=50&playlistId=PLaKLxbauAT7HijRdSmeYMlWB5rQGsB-Wv&key={YOUR_API_KEY}

    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId") channelId : String, @Query("key") apiKey : String, @Query("maxResults") limit : Int) : Call<PlaylistData>

    @GET("playlistItems?part=snippet%2CcontentDetails%2Cstatus")
    fun VideoGetir(@Query("playlistId") playlistId : String, @Query("key") apiKey : String, @Query("maxResults") limit : Int) : Call<PlaylistVideo>


}