package com.github.teren4m.words.screens.activity.main

import androidx.fragment.app.FragmentActivity
import com.github.teren4m.base.getViewModel
import com.github.teren4m.words.R
import com.github.teren4m.words.screens.word.list.IWordsListViewModel
import com.github.teren4m.words.screens.word.list.WordsListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class MainActivityModule {

    @Provides
    fun provideFragmentContainer(): Int = R.id.container

    @Provides
    fun provideActivity(activity: MainActivity): FragmentActivity = activity

    @Provides
    fun provideWordsListViewModel(
        activity: FragmentActivity,
        viewModel: Provider<WordsListViewModel>
    ): IWordsListViewModel =
        getViewModel<WordsListViewModel>(activity) {
            viewModel.get()
        }

}