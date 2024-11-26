package com.example.firstandroidapplication.core.domain.translation

import com.example.firstandroidapplication.core.TranslationApi
import com.example.firstandroidapplication.core.TranslationResponse
import com.example.firstandroidapplication.core.domain.LanguageCode
import javax.inject.Inject

class TranslationUseClass @Inject constructor(
    private val translationApi: TranslationApi
){
    suspend fun translate(sl: LanguageCode, dl: LanguageCode, text: String): TranslationResponse {
        return translationApi.translate(sl.code, dl.code, text)
    }
}