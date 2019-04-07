package com.github.teren4m.words.screens.word.list.model

import com.github.teren4m.words.screens.word.data.model.Word

sealed class WordItem {
    class Hebrew(val word: Word) : WordItem()
}