package com.github.teren4m.words.screens.activity.main

import androidx.fragment.app.FragmentActivity
import com.github.teren4m.base.getViewModel
import com.github.teren4m.words.R
import com.github.teren4m.words.screens.activity.main.modes.ActionModeFactory
import com.github.teren4m.words.screens.activity.main.modes.IActionModeFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module(
    includes = [
        SubMainModule::class
    ]
)
class MainActivityModule {

    @Provides
    fun provideFragmentContainer(): Int = R.id.container

    @Provides
    fun provideActivity(activity: MainActivity): FragmentActivity = activity

    @Provides
    fun getViewModel(
        activity: FragmentActivity,
        viewModel: Provider<MainViewModel>
    ): IMainViewModel =
        getViewModel<MainViewModel>(activity) {
            viewModel.get()
        }

}

@Module
abstract class SubMainModule {

    @Binds
    abstract fun provideActionModeFactory(factory: ActionModeFactory): IActionModeFactory

}