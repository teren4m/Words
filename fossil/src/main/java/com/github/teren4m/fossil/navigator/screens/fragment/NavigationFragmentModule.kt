package com.github.teren4m.fossil.navigator.screens.fragment

import androidx.fragment.app.Fragment
import com.github.teren4m.base.di.BaseModule
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class NavigationFragmentModule : BaseModule<NavigationFragment>() {

    @Provides
    fun provideViewModel(
        fragment: Fragment,
        viewModel: Provider<NavigationViewModel>
    ): INavigationViewModel =
        viewModel.get()

}