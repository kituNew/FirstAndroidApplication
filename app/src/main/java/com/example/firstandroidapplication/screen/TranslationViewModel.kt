package com.example.firstandroidapplication.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstandroidapplication.core.domain.TranslationUseClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val translationUseClass: TranslationUseClass,
):ViewModel() {
    private val _uiState = MutableStateFlow(TranslationUIState())
    val uiState: StateFlow<TranslationUIState> = _uiState

    fun updateInputText(text: String) {
        _uiState.update { it.copy(inputText = text) }
    }

    fun clearInputText () {
        _uiState.update { it.copy(inputText = "") }
    }

    fun swapLanguages() {
        _uiState.update {
            it.copy(
                sourceLang = it.targetLang,
                targetLang = it.sourceLang
            )
        }
    }

    fun translateText() {
        viewModelScope.launch {
            //var result =
        }
    }
}

data class TranslationUIState(
    val sourceLang: String = "English",
    val targetLang: String = "Russian",
    val inputText: String = "",
    val translatedText: String? = null
)