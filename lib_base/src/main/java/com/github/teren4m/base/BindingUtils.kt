package com.github.teren4m.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.teren4m.base.adapter.LastAdapter

@BindingAdapter(value = ["app:list_items"], requireAll = false)
fun setItems(view: RecyclerView, items: List<Any>?) {
    view.adapter?.let {
        if (it is LastAdapter) {
            it.update(items ?: emptyList())
        }
    }
}