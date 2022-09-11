package com.app.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<String>()
    val liveDataList = MutableLiveData<List<String>>()
}