package com.github.teren4m.words.screens.word.list

import androidx.fragment.app.Fragment
import com.github.teren4m.base.adapter.LastAdapter
import com.github.teren4m.base.getViewModel
import com.github.teren4m.words.BR
import com.github.teren4m.words.R
import com.github.teren4m.words.di.BaseModule
import com.github.teren4m.words.screens.word.HebrewWordViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class WordsListFragmentModule : BaseModule<WordsListFragment>() {

    @Provides
    fun provideAdapter(): LastAdapter =
        LastAdapter(BR.item)
            .addType<HebrewWordViewModel>(R.layout.item_hebrew)


    @Provides
    fun provideWordsListViewModel(
        fragment: Fragment,
        viewModel: Provider<WordsListViewModel>
    ): IWordsListViewModel =
        getViewModel<WordsListViewModel>(fragment) {
            viewModel.get()
        }
}