package com.github.teren4m.base.adapter

import com.github.teren4m.base.mvvm.ItemListViewModel
import kotlin.reflect.KClass

class LastAdapter(
    private val itemId: Int,
    list: MutableList<Any> = mutableListOf()
) : BaseAdapter(list) {

    val itemTypesMap = mutableMapOf<KClass<*>, Int>()

    inline fun <reified T> addType(layoutId: Int) = this.apply {
        itemTypesMap[T::class] = layoutId
    }

    override fun onBindViewHolder(holder: Holder, item: Any) {
        holder.binding.setVariable(itemId, item)
        holder.rootView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemViewType(item: Any): Int =
        if (item is ItemListViewModel) {
            val key = itemTypesMap.keys.first {
                item.isViewModelType(item)
            }
            itemTypesMap[key] ?: error("No layout for class ${item::class}")
        } else {
            itemTypesMap[item::class] ?: error("No layout for class ${item::class}")
        }
}