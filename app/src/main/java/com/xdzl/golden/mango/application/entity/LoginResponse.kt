package com.xdzl.golden.mango.application.entity

/*

Response body
Download
{
  "status": "0",
  "data": {
    "id": "999",
    "isDel": 0,
    "createDate": "2020-10-30T07:51:38.000+00:00",
    "createBy": 0,
    "updateDate": "2020-10-05T11:02:54.000+00:00",
    "updateBy": null,
    "name": "手持机用户",
    "loginname": "admin1",
    "password": "MTIz",
    "orgId": 0,
    "roleId": 2
  },
  "e": null,
  "msg": "操作成功"
}
**/


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

