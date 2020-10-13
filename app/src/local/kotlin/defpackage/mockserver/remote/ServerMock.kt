package defpackage.mockserver.remote

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import defpackage.mockserver.remote.api.Post
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class ServerMock(
    private val context: Context,
    private val gson: Gson
) : ServerApi {

    override fun getPosts(): Observable<List<Post>> {
        return Observable.fromCallable {
            val json = context.assets.open("posts.json").bufferedReader().use { it.readText() }
            gson.fromJson<List<Post>>(json, TypeToken.getParameterized(List::class.java, Post::class.java).type)
        }.delay((200..1000).random().toLong(), TimeUnit.MILLISECONDS)
    }
}