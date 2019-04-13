package com.github.teren4m.base

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.teren4m.base.adapter.LastAdapter

@BindingAdapter(value = ["app:edit_done"], requireAll = false)
fun setEditDone(view: EditText, call: Call?) {
    if (call != null)
        view.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                call.call()
                true;
            } else {
                false
            }
        }
}

@BindingAdapter(value = ["app:list_items_update"], requireAll = false)
fun updateItems(view: RecyclerView, items: List<Any>?) {
    view.adapter?.let {
        if (it is LastAdapter) {
            it.update(items ?: emptyList())
        }
    }
}

@BindingAdapter(value = ["app:list_items_set"], requireAll = false)
fun setItems(view: RecyclerView, items: List<Any>?) {
    view.adapter?.let {
        if (it is LastAdapter) {
            it.setData(items ?: emptyList())
        }
    }
}

interface Call {
    fun call()
}