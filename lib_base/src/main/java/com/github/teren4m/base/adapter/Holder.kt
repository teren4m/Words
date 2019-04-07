package com.github.teren4m.base.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class Holder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    val rootView: View = binding.root
}