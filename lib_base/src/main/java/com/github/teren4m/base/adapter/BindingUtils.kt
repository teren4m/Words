package com.github.teren4m.base.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["adapter"], requireAll = false)
fun setAdapter(view: RecyclerView, adapter: BaseAdapter) {
    view.adapter = adapter
}
