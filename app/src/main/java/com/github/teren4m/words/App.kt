package com.github.teren4m.words

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.github.teren4m.words.di.AppModule
import com.github.teren4m.words.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .setAppModule(AppModule(this))
            .build()
            .inject(this)

    }

    override fun activityInjector() = activityDispatchingAndroidInjector
}