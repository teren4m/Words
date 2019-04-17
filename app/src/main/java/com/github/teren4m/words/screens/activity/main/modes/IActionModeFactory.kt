package com.github.teren4m.words.screens.activity.main.modes

import com.github.teren4m.words.utils.Callback

interface IActionModeFactory {

    fun getMode(modeType: ModeType): Callback

    fun getMainMode(): Callback
    fun getCreateMode(): Callback

}