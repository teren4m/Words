package com.github.teren4m.words.screens.word.create

import androidx.databinding.ObservableField
import com.github.teren4m.base.mvvm.ActionLiveEvent

interface ICreateWordViewModel {

    val word: ObservableField<String>
    val transcription: ObservableField<String>
    val root: ObservableField<String>
    val partOfSpeech: ObservableField<String>
    val translation: ObservableField<String>

    val wordError: ObservableField<String>
    val transcriptionError: ObservableField<String>
    val rootError: ObservableField<String>
    val partOfSpeechError: ObservableField<String>
    val translationError: ObservableField<String>

    val onBack: ActionLiveEvent

    fun create()
}