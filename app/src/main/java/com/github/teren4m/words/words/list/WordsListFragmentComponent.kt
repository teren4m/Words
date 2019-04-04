package com.github.teren4m.words.words.list

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        WordsListFragmentModule::class
    ]
)
interface WordsListFragmentComponent : AndroidInjector<WordsListFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<WordsListFragment>()
}