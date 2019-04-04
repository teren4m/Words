package com.github.teren4m.words.words.data.converters

import com.github.teren4m.words.db.words.WordDTO
import com.github.teren4m.words.words.data.model.Word

interface IWordToWordDTOConverter {
    fun convert(word: Word): WordDTO
}