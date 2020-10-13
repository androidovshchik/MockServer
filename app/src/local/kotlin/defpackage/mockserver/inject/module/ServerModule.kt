package defpackage.mockserver.inject.module

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import defpackage.mockserver.remote.ServerApi
import defpackage.mockserver.remote.ServerMock
import javax.inject.Singleton

@Module
class ServerModule {

    @Provides
    @Singleton
    fun provideServerApi(context: Context, gson: Gson): ServerApi = ServerMock(context, gson)
}