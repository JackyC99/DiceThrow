package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val current : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getCurrentRoll() : LiveData<Int> {
        return current
    }

    fun setCurrentRoll(roll: Int) {
        current.value = roll

    }
}