package com.github.teren4m.words.screens.word.list

import com.github.teren4m.words.screens.word.list.model.WordItem
import com.github.teren4m.words.screens.word.HebrewWordViewModel
import com.github.teren4m.words.screens.word.IWordViewModel
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