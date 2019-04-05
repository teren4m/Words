package com.github.teren4m.words.activity

import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.words.activity.main.FragmentBuilder
import com.github.teren4m.words.activity.main.MainActivity
import com.github.teren4m.words.activity.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentBuilder::class
        ]
    )
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity

}