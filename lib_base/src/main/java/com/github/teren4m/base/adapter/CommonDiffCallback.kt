package com.github.teren4m.base.adapter

import androidx.recyclerview.widget.DiffUtil

class CommonDiffCallback(
    private var newPersons: List<Any>,
    private var oldPersons: List<Any>,
    private val merge: Merge?
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldPersons.size
    }

    override fun getNewListSize(): Int {
        return newPersons.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldPersons[oldItemPosition]
        val newItem = newPersons[newItemPosition]
        return if (oldItem is Id && newItem is Id) {
            oldItem.getId() == newItem.getId()
        } else {
            oldItem == newItem
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPersons[oldItemPosition] == newPersons[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return if (merge == null) {
            super.getChangePayload(oldItemPosition, newItemPosition)
        } else {
            merge.invoke(oldPersons[oldItemPosition], newPersons[newItemPosition])
        }
    }
}

typealias Merge = (Any, Any) -> Any?