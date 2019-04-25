package com.github.teren4m.base.mvvm

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import javax.inject.Inject

abstract class RouterBindMvvmFragment<R : Any, VM : Any, BV : ViewDataBinding> : BindMvvmFragment<VM, BV>() {

    abstract val routerId: Int

    @Inject
    lateinit var router: R

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(routerId, router)

    }

}