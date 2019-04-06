package com.github.teren4m.words.words.list

import com.github.teren4m.words.di.BaseFragmentModule
import dagger.Module

@Module
class WordsListFragmentModule : BaseFragmentModule<WordsListFragment, WordsListViewModel, IWordsListViewModel>() {

    override val viewModelClass = WordsListViewModel::class.java

}