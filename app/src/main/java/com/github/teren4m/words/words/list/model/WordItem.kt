package com.github.teren4m.words.words.list.model

import com.github.teren4m.words.words.data.model.Word

sealed class WordItem {
    class Hebrew(val word: Word) : WordItem()
}