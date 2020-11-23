package com.xdzl.golden.mango.application.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.xdzl.golden.mango.application.entity.HandleResponse

@BindingAdapter("bindTitle")
fun TextView.bindTitle(item: HandleResponse.HandleData) {
    text = item.name
}

@BindingAdapter("bindingInfo")
fun TextView.bindInfo(item: HandleResponse.HandleData) {
    text = item.createDate
}


