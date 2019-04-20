package com.github.teren4m.fossil.navigator

import com.github.teren4m.base.BaseApp

class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .setAppModule(AppModule(this))
            .build()
            .inject(this)

    }
}