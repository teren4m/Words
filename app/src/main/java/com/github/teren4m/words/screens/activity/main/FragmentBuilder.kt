package com.github.teren4m.words.screens.activity.main

import ai.sync.daggerx.FragmentScope
import com.github.teren4m.words.screens.word.list.WordsListFragment
import com.github.teren4m.words.screens.word.list.WordsListFragmentModule
import com.github.teren4m.words.screens.word.create.CreateWordFragment
import com.github.teren4m.words.screens.word.create.CreateWordFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
        modules = [
            WordsListFragmentModule::class
        ]
    )
    @FragmentScope
    abstract fun bindWordsListFragment(): WordsListFragment

    @ContributesAndroidInjector(
        modules = [
            CreateWordFragmentModule::class
        ]
    )
    @FragmentScope
    abstract fun bindCreateWordFragment(): CreateWordFragment

}