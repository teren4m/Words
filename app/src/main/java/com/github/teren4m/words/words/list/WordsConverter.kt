package com.github.teren4m.words.words.list

import com.github.teren4m.words.words.list.model.WordItem
import com.github.teren4m.words.words.word.HebrewWordViewModel
import com.github.teren4m.words.words.word.IWordViewModel
import javax.inject.Inject

class WordsConverter @Inject constructor() {

    fun toViewModels(items: List<WordItem>): List<IWordViewModel> =
        items.map(::toViewModel)

    fun toViewModel(wordItem: WordItem): IWordViewModel =
        when (wordItem) {
            is WordItem.Hebrew -> HebrewWordViewModel(
                wordItem
            )
        }

}