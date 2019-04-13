package com.github.teren4m.words.screens.activity.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.github.teren4m.base.BaseViewModelActivity
import com.github.teren4m.words.R

class MainActivity : BaseViewModelActivity<IMainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
