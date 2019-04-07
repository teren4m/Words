package com.github.teren4m.words.screens.word.data.converters

import com.github.teren4m.words.db.words.WordDTO
import com.github.teren4m.words.screens.word.data.model.Word

interface IWordDTOToWordConverter {

    fun convert(word: WordDTO): Word

}