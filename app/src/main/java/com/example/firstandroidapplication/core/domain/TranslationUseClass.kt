package com.example.firstandroidapplication.core.domain

import com.example.firstandroidapplication.core.TranslationApi
import javax.inject.Inject

class TranslationUseClass @Inject constructor(
    private val translationApi: TranslationApi
){
    suspend fun translate() {

    }
}