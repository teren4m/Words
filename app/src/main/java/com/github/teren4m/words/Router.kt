package com.github.teren4m.words

import javax.inject.Inject

class Router @Inject constructor(
    private val fragmentNavigation: FragmentNavigation
) : IRouter {

    override fun openCreateWordFragment() {
        fragmentNavigation.openCreate()
    }

}