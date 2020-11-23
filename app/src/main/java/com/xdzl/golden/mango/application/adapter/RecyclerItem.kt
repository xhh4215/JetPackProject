package com.xdzl.golden.mango.application.adapter

import com.xdzl.golden.mango.application.entity.HandleResponse

sealed class RecyclerItem {
    abstract val id: Long
    data class RecyclerViewItem(val handleData: HandleResponse.HandleData) : RecyclerItem() {
        override val id: Long = handleData.id as Long
    }


    object Header : RecyclerItem() {
        override val id: Long = Long.MIN_VALUE
    }

}

