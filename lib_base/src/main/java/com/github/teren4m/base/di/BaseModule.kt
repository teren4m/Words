package com.github.teren4m.base.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

@Module
abstract class BaseModule<T : Fragment> {

    @Provides
    fun provideFragment(fragment: T): Fragment =
        fragment

}