package com.github.teren4m.fossil.navigator.screens

import ai.sync.daggerx.FragmentScope
import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.fossil.navigator.screens.activity.MainActivity
import com.github.teren4m.fossil.navigator.screens.fragment.NavigationFragment
import com.github.teren4m.fossil.navigator.screens.fragment.NavigationFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuilder::class
        ]
    )
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity

}

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
        modules = [
            NavigationFragmentModule::class
        ]
    )
    @FragmentScope
    abstract fun bindNavigationFragment(): NavigationFragment

}