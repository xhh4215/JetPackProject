package com.xdzl.golden.mango.application.entity




data class LoginResponse(
    val status: Int,
    val data: LoginData,
    val msg: String
) {


    data class LoginData(
        val id: String,
        val isDel: Int,
        val createDate: String,
        val createBy: Int,
        val updateDate: String,
        val name: String,
        val loginname: String,
        val password: String,
        val updateBy: String?,
        val orgId: Int,
        val roleId: Int
    )

}

