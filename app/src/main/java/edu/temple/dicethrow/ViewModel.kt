package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModel : ViewModel() {

    private var dieSides: Int = 6

    private val current : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getCurrentRoll() : LiveData<Int> {
        return current
    }

    fun setCurrentRoll(roll: Int) {
        current.value = roll

    }

    fun rollDie() {
        setCurrentRoll(Random.nextInt(dieSides) + 1)
    }
}