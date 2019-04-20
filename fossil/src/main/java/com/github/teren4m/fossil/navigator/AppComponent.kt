package com.github.teren4m.fossil.navigator

import com.github.teren4m.fossil.navigator.screens.ActivityBuilder
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun setAppModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}