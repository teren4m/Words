package com.github.teren4m.words

import androidx.fragment.app.Fragment
import com.github.teren4m.words.words.word.create.CreateWordFragment
import javax.inject.Inject

class FragmentNavigation @Inject constructor(
    private val containerId: Int,
    private val fragment: Fragment
) : IFragmentNavigation {

    override fun openCreate() {
        fragment.activity?.run {
            supportFragmentManager
                .beginTransaction()
                .replace(containerId, CreateWordFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun back() {
        fragment.activity?.run {
            supportFragmentManager.popBackStack()
        }
    }
}