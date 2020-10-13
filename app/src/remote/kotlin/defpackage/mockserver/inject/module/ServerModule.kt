package defpackage.mockserver.inject.module

import dagger.Module
import dagger.Provides
import defpackage.mockserver.remote.ServerApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServerModule {

    @Provides
    @Singleton
    fun provideServerApi(retrofit: Retrofit): ServerApi = retrofit.create(ServerApi::class.java)
}