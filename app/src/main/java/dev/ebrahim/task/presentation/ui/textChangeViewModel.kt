package dev.ebrahim.task.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TextChangeViewModel : ViewModel() {

    private val _textLiveData = MutableLiveData("Hello!")
    val textLiveData: LiveData<String> = _textLiveData

    private val _textStateFlow = MutableStateFlow("Hello!")
    val textStateFlow: StateFlow<String> = _textStateFlow

    private val _textFlow = MutableSharedFlow<String>()
    val textFlow: Flow<String> = _textFlow


    private val _textSharedFlow = MutableSharedFlow<String>()
    val textSharedFlow: SharedFlow<String> = _textSharedFlow

    fun onLiveDataButtonClicked() {
        _textLiveData.value = "LiveData"
    }

    fun onStateFlowButtonClicked() {
        viewModelScope.launch {
            _textStateFlow.emit("StateFlow")
        }
    }


    fun onSharedFlowButtonClicked() {
        viewModelScope.launch {
            _textSharedFlow.emit("SharedFlow")
        }
    }


    fun onFlowButtonClicked() {
        viewModelScope.launch {
            _textFlow.emit("Flow")
        }
    }
    }
