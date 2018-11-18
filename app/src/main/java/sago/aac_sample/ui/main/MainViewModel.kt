package sago.aac_sample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    private val valueLiveData: MutableLiveData<String> = MutableLiveData()

    fun getValue(): LiveData<String> {
        return valueLiveData
    }

    fun setValue(value: String) {
        this.valueLiveData.value = value
    }
}
