package com.github.teren4m.words.activity

import com.github.teren4m.words.activity.main.MainActivity
import com.github.teren4m.words.activity.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<*>

}