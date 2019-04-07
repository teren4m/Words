package com.github.teren4m.words.di

import androidx.fragment.app.Fragment
import com.github.teren4m.words.IRouter
import com.github.teren4m.words.Router
import dagger.Module
import dagger.Provides

@Module
abstract class BaseModule<T : Fragment> {

    @Provides
    fun provideRouter(router: Router): IRouter =
        router

    @Provides
    fun provideFragment(fragment: T): Fragment =
        fragment

}