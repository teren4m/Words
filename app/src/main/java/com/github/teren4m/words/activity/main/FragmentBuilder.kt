package com.github.teren4m.words.activity.main

import ai.sync.daggerx.FragmentScope
import com.github.teren4m.words.words.create.CreateWordFragment
import com.github.teren4m.words.words.create.CreateWordFragmentModule
import com.github.teren4m.words.words.list.WordsListFragment
import com.github.teren4m.words.words.list.WordsListFragmentModule
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