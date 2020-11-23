package com.xdzl.golden.mango.application.adapter

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.RecycleviewItemBinding
import com.xdzl.golden.mango.application.entity.HandleResponse
import java.lang.ClassCastException

class RecycleViewAdapter(val clickListener: RecycleViewListener) :
    ListAdapter<RecyclerItem, RecyclerView.ViewHolder>(RecycleViewDiffCallback()) {
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_ITEM -> RecycleViewHolder.from(parent)
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            else -> throw  ClassCastException("unknow viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RecyclerItem.Header -> ITEM_VIEW_TYPE_HEADER
            is RecyclerItem.RecyclerViewItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecycleViewHolder -> {
                val item = getItem(position) as RecyclerItem.RecyclerViewItem
                holder.bind(item.handleData, clickListener)
            }
        }

    }

    fun addHeaderAndSubmitList(list: List<HandleResponse.HandleData>?) {
        val items = when (list) {
            null -> listOf(RecyclerItem.Header)
            else -> listOf(RecyclerItem.Header) + list.map { RecyclerItem.RecyclerViewItem(it) }
        }
        submitList(items)
    }

}

class RecycleViewDiffCallback : DiffUtil.ItemCallback<RecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: RecyclerItem,
        newItem: RecyclerItem
    ): Boolean {
        return oldItem == newItem
    }


}

class RecycleViewListener(val clickListener: (sleepId: Int) -> Unit) {
    fun onClick(recyclerViewResponse: Int) =
        clickListener(recyclerViewResponse)
}


class RecycleViewHolder private constructor(val binding: RecycleviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): RecycleViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RecycleviewItemBinding.inflate(layoutInflater, parent, false)
            return RecycleViewHolder(binding)
        }
    }

    fun bind(
        recyclerResponse: HandleResponse.HandleData,
        clickListener: RecycleViewListener
    ) {
        binding.clicklistener = clickListener
        binding.item = recyclerResponse
        binding.executePendingBindings()
    }
}


class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.recycler_header_layout, parent, false)
            return HeaderViewHolder(view)
        }
    }
}
