package com.github.teren4m.words.di

import com.github.teren4m.words.App
import com.github.teren4m.words.activity.ActivityBuilder
import com.github.teren4m.words.db.DataBaseModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        UseCaseViewModel::class,
        RepositoryModule::class,
        ConvertersModule::class,
        DataBaseModule::class
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