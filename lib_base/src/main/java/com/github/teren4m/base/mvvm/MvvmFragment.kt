package com.github.teren4m.base.mvvm

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.github.teren4m.base.inject
import javax.inject.Inject

abstract class MvvmFragment<VM : Any, BV : ViewDataBinding> : BindingFragment<BV>() {

    @Inject
    lateinit var viewModel: VM

    abstract val viewModelId: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        binding {
            setVariable(viewModelId, viewModel)
        }
    }
}