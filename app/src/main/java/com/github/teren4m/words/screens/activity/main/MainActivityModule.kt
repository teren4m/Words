package com.github.teren4m.words.screens.activity.main

import com.github.teren4m.words.R
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideFragmentContainer(): Int = R.id.container

}