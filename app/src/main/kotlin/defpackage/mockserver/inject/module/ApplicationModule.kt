package defpackage.mockserver.inject.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: DaggerApplication): Context = application.applicationContext
}
