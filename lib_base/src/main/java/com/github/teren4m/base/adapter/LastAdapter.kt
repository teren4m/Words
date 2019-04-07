package com.github.teren4m.base.adapter

import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

class LastAdapter(
    private val itemId: Int,
    list: MutableList<Any> = mutableListOf()
) : BaseAdapter(list) {

    val itemTypesMap = mutableMapOf<KClass<*>, Int>()

    inline fun <reified T> addType(layoutId: Int) = this.apply {
        itemTypesMap[T::class] = layoutId
    }

    fun into(list: RecyclerView) = this.apply { list.adapter = this }

    override fun onBindViewHolder(holder: Holder, item: Any) {
        holder.binding.setVariable(itemId, item)
        holder.rootView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            list[position] = payloads[0]
            onBindViewHolder(holder, payloads[0])
        }
    }

    override fun getItemViewType(item: Any): Int =
        itemTypesMap[item::class] ?: error("No layout for class ${item::class}")
}