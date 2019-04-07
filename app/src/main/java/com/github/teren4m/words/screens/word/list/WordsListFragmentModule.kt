package com.github.teren4m.words.screens.word.list

import com.github.teren4m.base.adapter.LastAdapter
import com.github.teren4m.words.BR
import com.github.teren4m.words.R
import com.github.teren4m.words.di.BaseModule
import com.github.teren4m.words.screens.word.HebrewWordViewModel
import dagger.Module
import dagger.Provides

@Module
class WordsListFragmentModule : BaseModule<WordsListFragment>() {

    @Provides
    fun provideAdapter(): LastAdapter =
        LastAdapter(BR.item)
            .addType<HebrewWordViewModel>(R.layout.item_hebrew)

}