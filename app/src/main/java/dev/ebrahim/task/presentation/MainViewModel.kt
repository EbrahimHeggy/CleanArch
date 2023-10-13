package dev.ebrahim.task.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ebrahim.task.domain.usecase.GetPhoneUseCase
import dev.ebrahim.task.presentation.mapper.toPhoneUiModel
import dev.ebrahim.task.presentation.models.UiModel
import kotlinx.coroutines.launch


class PhoneViewModel(private val getPhoneUseCase: GetPhoneUseCase) : ViewModel() {
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel>
        get() = _uiModel

    init {
        fetchAndDisplayPhone()
    }

    fun fetchAndDisplayPhone() {
        viewModelScope.launch {
            val phoneDM = getPhoneUseCase.execute()
            _uiModel.value = phoneDM.toPhoneUiModel()
        }
    }
}
