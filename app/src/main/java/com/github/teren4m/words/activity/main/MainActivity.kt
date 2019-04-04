package com.github.teren4m.words.activity.main

import android.os.Bundle
import com.github.teren4m.base.BaseActivity
import com.github.teren4m.words.R
import com.github.teren4m.words.words.list.WordsListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WordsListFragment())
                .commit()
        }
    }
}
