package com.xdzl.golden.mango.application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xdzl.golden.mango.application.R
import com.xdzl.golden.mango.application.databinding.RecycleviewItemBinding
import com.xdzl.golden.mango.application.entity.HandleResponse

class RecycleViewAdapter(val clickListener: RecycleViewListener) :
    ListAdapter<HandleResponse.HandleData, RecycleViewHolder>(RecycleViewDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
}

class RecycleViewDiffCallback : DiffUtil.ItemCallback<HandleResponse.HandleData>() {
    override fun areItemsTheSame(
        oldItem: HandleResponse.HandleData,
        newItem: HandleResponse.HandleData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: HandleResponse.HandleData,
        newItem: HandleResponse.HandleData
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
        binding.mainItemInputTextOne.text = recyclerResponse.name
        binding.mainItemInputTextTwo.text = recyclerResponse.createDate
        binding.mainItemInputImg.setImageResource(R.drawable.main_item_one)
    }
}
