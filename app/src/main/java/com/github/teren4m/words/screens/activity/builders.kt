package com.github.teren4m.words.screens.activity

import ai.sync.daggerx.FragmentScope
import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.words.screens.activity.main.MainActivity
import com.github.teren4m.words.screens.activity.main.MainActivityModule
import com.github.teren4m.words.screens.word.create.CreateWordFragment
import com.github.teren4m.words.screens.word.create.CreateWordFragmentModule
import com.github.teren4m.words.screens.word.list.WordsListFragment
import com.github.teren4m.words.screens.word.list.WordsListFragmentModule
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