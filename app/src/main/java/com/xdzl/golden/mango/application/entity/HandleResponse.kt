package com.xdzl.golden.mango.application.entity

data class HandleResponse(
    val status: Int,
    val data: Array<HandleData>,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HandleResponse

        if (status != other.status) return false
        if (!data.contentEquals(other.data)) return false
        if (msg != other.msg) return false

        return true
    }

    override fun hashCode(): Int {
        var result = status
        result = 31 * result + data.contentHashCode()
        result = 31 * result + msg.hashCode()
        return result
    }
}