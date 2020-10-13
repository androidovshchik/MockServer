package defpackage.mockserver

import dagger.android.support.DaggerApplication
import defpackage.mockserver.inject.DaggerApplicationComponent

@Suppress("unused")
class MainApp : DaggerApplication() {

    override fun applicationInjector() = DaggerApplicationComponent.builder()
        .application(this)
        .build()
}