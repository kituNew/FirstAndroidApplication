package com.example.firstandroidapplication.screen.history

import androidx.lifecycle.ViewModel
import com.example.firstandroidapplication.core.data.TranslationHistory
import com.example.firstandroidapplication.core.data.TranslationHistoryDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
): ViewModel() {
    fun getHistory(): Flow<List<TranslationHistory>> {
        return translationHistoryDao.getTranslationHistory()
    }
}