package com.example.firstandroidapplication.core.domain.history

import com.example.firstandroidapplication.core.data.TranslationHistory
import com.example.firstandroidapplication.core.data.TranslationHistoryDao
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
){
    suspend fun save(sourceText: String, translationText: String) {
        translationHistoryDao.insertHistory(
            TranslationHistory(
                sourceText = sourceText,
                translatedText = translationText,
            )
        )
    }
}