package defpackage.mockserver.remote

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import defpackage.mockserver.remote.api.Post
import io.reactivex.Observable
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.util.concurrent.TimeUnit

class ServerMock(
    private val context: Context,
    private val gson: Gson
) : ServerApi {

    override fun getPosts(): Observable<List<Post>> {
        return Observable.fromCallable {
            if ((1..10).random() < 3) {
                throw HttpException(Response.error<Any>(404, "".toResponseBody()))
            }
            val json = context.assets.open("posts.json").bufferedReader().use { it.readText() }
            gson.fromJson<List<Post>>(json, TypeToken.getParameterized(List::class.java, Post::class.java).type)
        }.delaySubscription((200..1000).random().toLong(), TimeUnit.MILLISECONDS)
    }
}