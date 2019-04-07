package com.github.teren4m.words.screens.activity

import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.words.screens.activity.main.FragmentBuilder
import com.github.teren4m.words.screens.activity.main.MainActivity
import com.github.teren4m.words.screens.activity.main.MainActivityModule
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