package com.github.teren4m.fossil.navigator.di

import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.INavigationUseCase
import com.github.teren4m.fossil.navigator.screens.fragment.navigation.domain.NavigationUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindNavigationUseCase(navigationUseCase: NavigationUseCase): INavigationUseCase

}