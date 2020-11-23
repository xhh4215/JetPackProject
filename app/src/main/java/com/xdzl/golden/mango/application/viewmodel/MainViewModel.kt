package com.xdzl.golden.mango.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xdzl.golden.mango.application.entity.HandleResponse
import com.xdzl.golden.mango.application.network.GoldenMangoApi
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(loginStatus: String) : ViewModel() {
    private val _handleData = MutableLiveData<ArrayList<HandleResponse.HandleData>>()
    val handleData: LiveData<ArrayList<HandleResponse.HandleData>> get() = _handleData
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin
    private val status = loginStatus

    init {
        _isLogin.value = status != "nouser"
    }

    fun handle(userId: String) {
        viewModelScope.launch {
            val handleResult =
                GoldenMangoApi.retrofitService.userHandle(userId)
            if (handleResult.msg == LoginViewModel.LOG_FLAG) {
                Timber.d("Login ViewModel Handle")
                _handleData.value =
                    handleResult.data as ArrayList<HandleResponse.HandleData>
            }
        }

    }


}