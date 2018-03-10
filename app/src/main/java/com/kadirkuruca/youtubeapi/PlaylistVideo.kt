package com.kadirkuruca.youtubeapi

import com.google.gson.annotations.SerializedName

/**
 * Created by Kadir on 10.03.2018.
 */

class PlaylistVideo {

    @SerializedName("kind")
    var kind: String? = null
    @SerializedName("etag")
    var etag: String? = null
    @SerializedName("pageInfo")
    var pageInfo: PageInfo? = null
    @SerializedName("items")
    var items: List<İtems>? = null

    class PageInfo {
        @SerializedName("totalResults")
        var totalResults: Int = 0
        @SerializedName("resultsPerPage")
        var resultsPerPage: Int = 0
    }

    class MyDefault {
        @SerializedName("url")
        var url: String? = null
        @SerializedName("width")
        var width: Int = 0
        @SerializedName("height")
        var height: Int = 0
    }

    class Medium {
        @SerializedName("url")
        var url: String? = null
        @SerializedName("width")
        var width: Int = 0
        @SerializedName("height")
        var height: Int = 0
    }

    class High {
        @SerializedName("url")
        var url: String? = null
        @SerializedName("width")
        var width: Int = 0
        @SerializedName("height")
        var height: Int = 0
    }

    class Standard {
        @SerializedName("url")
        var url: String? = null
        @SerializedName("width")
        var width: Int = 0
        @SerializedName("height")
        var height: Int = 0
    }

    class Maxres {
        @SerializedName("url")
        var url: String? = null
        @SerializedName("width")
        var width: Int = 0
        @SerializedName("height")
        var height: Int = 0
    }

    class Thumbnails {
        @SerializedName("default")
        var mdefault: MyDefault? = null
        @SerializedName("medium")
        var medium: Medium? = null
        @SerializedName("high")
        var high: High? = null
        @SerializedName("standard")
        var standard: Standard? = null
        @SerializedName("maxres")
        var maxres: Maxres? = null
    }

    class ResourceId {
        @SerializedName("kind")
        var kind: String? = null
        @SerializedName("videoId")
        var videoId: String? = null
    }

    class Snippet {
        @SerializedName("publishedAt")
        var publishedAt: String? = null
        @SerializedName("channelId")
        var channelId: String? = null
        @SerializedName("title")
        var title: String? = null
        @SerializedName("description")
        var description: String? = null
        @SerializedName("thumbnails")
        var thumbnails: Thumbnails? = null
        @SerializedName("channelTitle")
        var channelTitle: String? = null
        @SerializedName("playlistId")
        var playlistId: String? = null
        @SerializedName("position")
        var position: Int = 0
        @SerializedName("resourceId")
        var resourceId: ResourceId? = null
    }

    class ContentDetails {
        @SerializedName("videoId")
        var videoId: String? = null
        @SerializedName("videoPublishedAt")
        var videoPublishedAt: String? = null
    }

    class Status {
        @SerializedName("privacyStatus")
        var privacyStatus: String? = null
    }

    class İtems {
        @SerializedName("kind")
        var kind: String? = null
        @SerializedName("etag")
        var etag: String? = null
        @SerializedName("id")
        var id: String? = null
        @SerializedName("snippet")
        var snippet: Snippet? = null
        @SerializedName("contentDetails")
        var contentDetails: ContentDetails? = null
        @SerializedName("status")
        var status: Status? = null
    }
}
