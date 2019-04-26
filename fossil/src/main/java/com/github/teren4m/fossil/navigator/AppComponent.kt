package com.github.teren4m.fossil.navigator

import com.github.teren4m.fossil.navigator.core.CoreModule
import com.github.teren4m.fossil.navigator.di.NetworkModule
import com.github.teren4m.fossil.navigator.di.RepositoryModule
import com.github.teren4m.fossil.navigator.di.UseCaseModule
import com.github.teren4m.fossil.navigator.screens.ActivityBuilder
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        UseCaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoreModule::class
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