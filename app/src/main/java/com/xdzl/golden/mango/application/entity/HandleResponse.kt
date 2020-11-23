package com.xdzl.golden.mango.application.entity

data class HandleResponse(
    val status: String,
    val data: ArrayList<HandleData>,
    val msg: String
) {
    data class HandleData(
        val id: Int,
        val isDel: Int,
        val createDate: String,
        val createBy: Int,
        val updateDate: String,
        val code: String,
        val name: String,
        val type: Int,
        val url: String
    )
}