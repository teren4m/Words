package com.github.teren4m.words.screens.activity.main

import android.os.Bundle
import com.github.teren4m.base.BaseViewModelActivity
import com.github.teren4m.base.observe
import com.github.teren4m.words.R
import com.github.teren4m.words.screens.activity.main.modes.IActionModeFactory
import com.github.teren4m.words.utils.ToolbarActionHelper
import javax.inject.Inject

class MainActivity : BaseViewModelActivity<IMainViewModel>() {

    override val toolbarId = R.id.toolbar

    override val layoutId = R.layout.activity_main

    @Inject
    lateinit var actionModeFactory: IActionModeFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbarActionHelper = ToolbarActionHelper(
            this,
            toolbar
        )

        viewModel.toolbarMode.observe(this) { modeType ->

            modeType
                .let(actionModeFactory::getMode)
                .let(toolbarActionHelper::start)

        }

    }
}
