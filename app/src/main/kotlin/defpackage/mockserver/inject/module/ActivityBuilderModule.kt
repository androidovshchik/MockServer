@file:Suppress("unused")

package defpackage.mockserver.inject.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import defpackage.mockserver.MainActivity
import defpackage.mockserver.inject.scope.PerActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    @PerActivity
    abstract fun contributeMainActivity(): MainActivity
}
