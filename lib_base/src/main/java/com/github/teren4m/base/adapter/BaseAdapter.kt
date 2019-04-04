package com.github.teren4m.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
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

    fun set(dataList: List<Any>) = apply {
        list.clear()
        add(dataList)
    }

    fun add(dataList: List<Any>) = apply {
        list.addAll(dataList)
        notifyDataSetChanged()
    }

    fun add(data: Any) = apply {
        list.add(data)
        notifyItemInserted(list.size - 1)
    }
}

class Holder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    val rootView: View = binding.root
}
