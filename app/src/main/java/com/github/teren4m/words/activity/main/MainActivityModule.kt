package com.github.teren4m.words.activity.main

import com.github.teren4m.words.R
import com.github.teren4m.words.words.create.CreateWordFragmentComponent
import com.github.teren4m.words.words.list.WordsListFragmentComponent
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
        WordsListFragmentComponent::class,
        CreateWordFragmentComponent::class
    ]
)
class MainActivityModule {

    @Provides
    fun provideFragmentContainer(): Int = R.id.container

}