package com.xdzl.golden.mango.application.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xdzl.golden.mango.application.entity.HandleResponse
import com.xdzl.golden.mango.application.network.GoldenMangoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(loginStatus: String) : ViewModel() {
    private val _handleData = MutableLiveData<HandleResponse>()
    val handleData: LiveData<HandleResponse> get() = _handleData
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin
    private val status = loginStatus

    init {
        _isLogin.value = status != "nouser"
    }

    fun handleIn(userId: String) {
        Log.d("lgm", userId)
        viewModelScope.launch(Dispatchers.IO) {
            val handleResult = GoldenMangoApi.retrofitService.userHandle(userId)

            if (handleResult.msg == LoginViewModel.LOG_FLAG) {
                Timber.d("Login ViewModel Handle")
                _handleData.value = handleResult
            }
        }
    }


    fun initList() {
        // val id: Int,
        //        val isDel: Int,
        //        val createDate: String,
        //        val createBy: Int,
        //        val updateDate: String,
        //        val code: String,
        //        val name: String,
        //        val type: Int,
        //        val url: String
        _handleData.value = HandleResponse(
            "1",
            arrayListOf(
                HandleResponse.HandleData(
                    1,
                    1,
                    "高频扫描装盘",
                    1,
                    "2020,12,23",
                    "1",
                    "装盘",
                    1,
                    "sdfd"
                ),
                HandleResponse.HandleData(
                    1,
                    1,
                    "高频扫描入库",
                    1,
                    "2020,12,23",
                    "1",
                    "入库",
                    1,
                    "sdfd"
                ),
                HandleResponse.HandleData(1, 1, "高频扫描出库", 1, "2020,12,23", "1", "出库", 1, "sdfd")
            ),
            "加载成功"
        )

    }


}