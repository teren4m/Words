package com.github.teren4m.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter(protected val list: MutableList<Any>) : RecyclerView.Adapter<Holder>() {

    private var layoutInflater: LayoutInflater? = null
    protected var onItemClick: (Any) -> Unit = {}

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.context)
        }

        val view = layoutInflater!!.inflate(i, viewGroup, false)
        val binding = DataBindingUtil.bind<ViewDataBinding>(view)!!
        return Holder(binding)
    }

    final override fun onBindViewHolder(holder: Holder, position: Int) {
        onBindViewHolder(holder, list[position])
    }

    override fun getItemCount() = list.size

    abstract fun onBindViewHolder(holder: Holder, item: Any)

    final override fun getItemViewType(position: Int) = getItemViewType(list[position])

    abstract fun getItemViewType(item: Any): Int

    fun update(dataList: List<Any>, merge: Merge? = null) {
        val diff = DiffUtil.calculateDiff(CommonDiffCallback(dataList, this.list, merge))
        diff.dispatchUpdatesTo(this)
        this.list.clear()
        this.list.addAll(dataList)
    }

    fun setData(dataList: List<Any>) = apply {
        list.clear()
        addData(dataList)
    }

    fun addData(dataList: List<Any>) = apply {
        list.addAll(dataList)
        notifyDataSetChanged()
    }

    fun addData(data: Any?) = apply {
        if (data != null) {
            list.add(data)
            notifyItemInserted(list.size - 1)
        }
    }

    fun removeData(data: Any?) = apply {
        if (data != null) {
            list.remove(data)
            notifyDataSetChanged()
        }
    }

    fun setOnItemClick(f: (Any) -> Unit) = apply {
        onItemClick = f
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun get(): List<Any> = list

    fun isEmpty() = list.isEmpty()
}