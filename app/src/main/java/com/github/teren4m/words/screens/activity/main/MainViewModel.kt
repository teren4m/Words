package com.github.teren4m.words.screens.activity.main

import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.words.screens.activity.main.modes.ModeType
import javax.inject.Inject

@ActivityScope
class MainViewModel
@Inject constructor() : IMainViewModel, BaseViewModel() {

    override val toolbarMode = MutableLiveData<ModeType>()

    override fun startMode(modeType: ModeType) {
        toolbarMode.value = modeType
    }

}