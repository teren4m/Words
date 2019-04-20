package com.github.teren4m.fossil.navigator.screens

import com.github.teren4m.base.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun bindMainActivity(): NavigationActivity

}