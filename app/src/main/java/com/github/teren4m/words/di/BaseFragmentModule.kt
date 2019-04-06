package com.github.teren4m.words.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.teren4m.base.ViewModelFactory
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.words.IRouter
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
abstract class BaseFragmentModule<T : Fragment, VM : BaseViewModel, IVM> {

    @Provides
    fun provideRouter(): IRouter =
        object : IRouter {

        }

    @Provides
    fun provideFragment(fragment: T): Fragment =
        fragment

    @Provides
    fun provideViewModel(
        fragment: T,
        viewModelProvider: Provider<VM>
    ): IVM {
        return ViewModelFactory { viewModelProvider.get() }.let {
            ViewModelProviders.of(fragment, it).get(viewModelClass) as IVM
        }
    }

    abstract val viewModelClass: Class<VM>

}