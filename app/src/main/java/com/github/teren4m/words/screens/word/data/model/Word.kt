package com.github.teren4m.words.screens.word.data.model

import com.github.teren4m.words.Uuid

class Word(
    val uuid: Uuid,
    val word: String,
    val transcription: String,
    val root: String,
    val partOfSpeech: String,
    val translation: String
)