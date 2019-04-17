package com.github.teren4m.words.screens.activity.main.modes

import com.github.teren4m.words.utils.Callback
import javax.inject.Inject

class ActionModeFactory
@Inject constructor() : IActionModeFactory {

    override fun getMode(modeType: ModeType): Callback =
        when (modeType) {
            ModeType.MAIN -> getMainMode()
            ModeType.CREATE -> getCreateMode()
        }

    override fun getMainMode(): Callback = MainMode()

    override fun getCreateMode(): Callback = CreateMode()

}