package com.github.teren4m.words.utils

import android.app.Activity
import androidx.appcompat.widget.Toolbar
import com.gojuno.koptional.None
import com.gojuno.koptional.Some

class ToolbarActionHelper(
    private val activity: Activity,
    private val toolbar: Toolbar
) {

    fun start(callback: Callback) {

        toolbar.navigationIcon = callback.icon.let {
            when (it) {
                is Some -> activity.getDrawable(it.value)
                None -> null
            }
        }

    }

}