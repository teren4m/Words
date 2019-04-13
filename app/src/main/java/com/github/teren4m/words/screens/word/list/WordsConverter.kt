package com.github.teren4m.words.screens.word.list

import com.github.teren4m.words.screens.word.HebrewWordViewModel
import com.github.teren4m.words.screens.word.IWordViewModel
import com.github.teren4m.words.screens.word.list.model.Divider
import com.github.teren4m.words.screens.word.list.model.WordItem
import javax.inject.Inject

class WordsConverter @Inject constructor() {

    fun toViewModels(items: List<WordItem>): List<Any> =
        items
            .asSequence()
            .map(::toViewModel)
            .map {
                listOf(
                    Divider, it
                )
            }
            .flatten()
            .plus(Divider)
            .toList()

    fun toViewModel(wordItem: WordItem): IWordViewModel =
        when (wordItem) {
            is WordItem.Hebrew -> HebrewWordViewModel(
                wordItem
            )
        }

}