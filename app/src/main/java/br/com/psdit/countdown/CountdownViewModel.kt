package br.com.psdit.countdown

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class CountdownViewModel : ViewModel() {

    private val _timeLeft = MutableStateFlow(45 * 60) // 30 minutos em segundos
    val timeLeft: StateFlow<Int> = _timeLeft

    fun startCountdown() {
        viewModelScope.launch {
            while (isActive && _timeLeft.value > 0) {
                delay(1000)
                _timeLeft.value -= 1
            }
        }
    }

    fun pause() {
        viewModelScope.coroutineContext.cancelChildren() // Para a contagem
    }

    fun resume() {
        startCountdown() // Retoma a contagem
    }

    fun reset(seconds: Int = 45 * 60) {
        _timeLeft.value = seconds
    }
}