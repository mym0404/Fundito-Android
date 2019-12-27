package com.fundito.fundito.presentation.main.status

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by mj on 28, December, 2019
 */
class StatusViewModel @Inject constructor() : ViewModel() {

    val sheetOpenCount : MutableLiveData<Int> = MutableLiveData(0)
}