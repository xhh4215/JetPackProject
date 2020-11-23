package com.xdzl.golden.mango.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xdzl.golden.mango.application.entity.HandleResponse
import com.xdzl.golden.mango.application.network.GoldenMangoApi
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModel : ViewModel() {
    companion object {
        const val LOG_FLAG = "操作成功"
    }

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin


    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String> get() = _userId


    init {
        Timber.d("Login ViewModel Init")
        _isLogin.value = false
        _userId.value = "12"

    }

    /****
     * 登陆操作
     */
    fun onLogin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val loginResult = GoldenMangoApi.retrofitService.login(username, password)

                if (loginResult.msg == LOG_FLAG) {
                    _isLogin.value = true
                    _userId.value = loginResult.data.id
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}