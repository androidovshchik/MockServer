package defpackage.mockserver.inject

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import defpackage.mockserver.inject.module.ActivityBuilderModule
import defpackage.mockserver.inject.module.ApplicationModule
import defpackage.mockserver.inject.module.NetworkModule
import defpackage.mockserver.inject.module.ServerModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilderModule::class,
    NetworkModule::class,
    ServerModule::class
])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: DaggerApplication): Builder

        fun build(): ApplicationComponent
    }
}
