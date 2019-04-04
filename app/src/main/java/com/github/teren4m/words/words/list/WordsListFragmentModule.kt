package com.github.teren4m.words.words.list

import androidx.fragment.app.Fragment
import com.github.teren4m.base.getViewModel
import com.github.teren4m.words.FragmentNavigation
import com.github.teren4m.words.IFragmentNavigation
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class WordsListFragmentModule {

    @Provides
    fun provideFragment(fragment: WordsListFragment): Fragment =
        fragment

    @Provides
    fun provideViewModel(fragment: Fragment, viewModel: Provider<WordsListViewModel>): IWordsListViewModel =
        getViewModel<WordsListViewModel>(fragment) {
            viewModel.get()
        }

    @Provides
    fun getNavigation(provider: Provider<FragmentNavigation>): IFragmentNavigation =
        provider.get()
}