package com.github.teren4m.base

import android.app.Activity
import androidx.fragment.app.Fragment
import com.github.teren4m.base.di.fragmentx.AndroidxInjection
import dagger.android.AndroidInjection

fun Activity.inject() {
    AndroidInjection.inject(this)
}

fun Fragment.inject() {
    AndroidxInjection.inject(this)
}