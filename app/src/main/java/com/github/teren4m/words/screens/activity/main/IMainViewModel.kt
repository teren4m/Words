package com.github.teren4m.words.screens.activity.main

import androidx.lifecycle.LiveData
import com.github.teren4m.words.screens.activity.main.modes.ModeType

interface IMainViewModel {

    val toolbarMode: LiveData<ModeType>

    fun startMode(modeType: ModeType)

}