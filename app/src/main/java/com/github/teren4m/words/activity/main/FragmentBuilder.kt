package com.github.teren4m.words.activity.main

import com.github.teren4m.words.words.create.CreateWordFragment
import com.github.teren4m.words.words.create.CreateWordFragmentComponent
import com.github.teren4m.words.words.list.WordsListFragment
import com.github.teren4m.words.words.list.WordsListFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @ClassKey(WordsListFragment::class)
    internal abstract fun bindAccessPermsissionFragment(
        builder: WordsListFragmentComponent.Builder
    ): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(CreateWordFragment::class)
    internal abstract fun bindAccessCreateWordFragment(
        builder: CreateWordFragmentComponent.Builder
    ): AndroidInjector.Factory<*>

}