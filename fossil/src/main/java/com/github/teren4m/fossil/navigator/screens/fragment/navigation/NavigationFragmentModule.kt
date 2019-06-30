package com.github.teren4m.fossil.navigator.screens.fragment.navigation

import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class NavigationFragmentModule {

    @Provides
    fun provideViewModel(
        fragment: NavigationFragment,
        viewModel: Provider<NavigationViewModel>
    ): INavigationViewModel =
        viewModel.get()

}