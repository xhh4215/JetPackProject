package com.xdzl.golden.mango.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OutInputViewModel : ViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    private val _bottomText = MutableLiveData<String>()
    val bottomText: LiveData<String> get() = _bottomText

    private val _nfcText = MutableLiveData<String>()
    val nfcText: LiveData<String> get() = _nfcText
    init {
        _title.value = "扫码出库"
        _nfcText.value = "扫描托盘的NFC标签出库"
        _bottomText.value = "识别芯片出库"
    }



    fun setInputTitle() {
        _title.value = "扫码入库"
        _nfcText.value = "扫描托盘的NFC标签入库"
        _bottomText.value = "识别芯片入库"
    }


    fun setOutputTitle() {
        _title.value = "扫码出库"
        _nfcText.value = "扫描托盘的NFC标签出库"
        _bottomText.value = "识别芯片出库"
    }
}