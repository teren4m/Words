package com.github.teren4m.words.words.word.create

import androidx.fragment.app.Fragment
import com.github.teren4m.base.getViewModel
import com.github.teren4m.words.FragmentNavigation
import com.github.teren4m.words.IFragmentNavigation
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class CreateWordFragmentModule {

    @Provides
    fun provideFragment(fragment: CreateWordFragment): Fragment =
        fragment

    @Provides
    fun provideViewModel(fragment: Fragment, viewModel: Provider<CreateWordViewModel>): ICreateWordViewModel =
        getViewModel<CreateWordViewModel>(fragment) {
            viewModel.get()
        }

    @Provides
    fun getNavigation(provider: Provider<FragmentNavigation>): IFragmentNavigation =
        provider.get()
}