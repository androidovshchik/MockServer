package defpackage.mockserver.remote

import defpackage.mockserver.remote.api.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ServerApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}