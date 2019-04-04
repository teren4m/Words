package com.github.teren4m.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.teren4m.base.di.fragmentx.HasAndroidxFragmentInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasAndroidxFragmentInjector {

    @Inject
    lateinit var androidxFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun androidxFragmentInjector() = androidxFragmentInjector
}