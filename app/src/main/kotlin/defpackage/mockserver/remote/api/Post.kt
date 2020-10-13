package defpackage.mockserver.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("userId")
    @Expose
    var userId = 0

    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("title")
    @Expose
    lateinit var title: String

    @SerializedName("body")
    @Expose
    lateinit var body: String
}