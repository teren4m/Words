package com.github.teren4m.words.activity.main

import androidx.fragment.app.Fragment
import com.github.teren4m.base.di.fragmentx.FragmentKey
import com.github.teren4m.words.words.create.CreateWordFragment
import com.github.teren4m.words.words.create.CreateWordFragmentComponent
import com.github.teren4m.words.words.list.WordsListFragment
import com.github.teren4m.words.words.list.WordsListFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(WordsListFragment::class)
    internal abstract fun bindAccessPermsissionFragment(builder: WordsListFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(CreateWordFragment::class)
    internal abstract fun bindAccessCreateWordFragment(builder: CreateWordFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

}