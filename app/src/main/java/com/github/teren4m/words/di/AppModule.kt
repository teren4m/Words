package com.github.teren4m.words.di

import android.content.ContentResolver
import android.content.Context
import androidx.work.WorkManager
import com.github.teren4m.words.App
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideContentResolver(context: Context): ContentResolver = context.contentResolver

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideWorkManager(): WorkManager = WorkManager.getInstance()
}