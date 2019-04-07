package com.github.teren4m.words.screens.word.list

import androidx.databinding.ObservableField
import com.github.teren4m.words.screens.word.list.model.WordItem

interface IWordsListViewModel {

    val items: ObservableField<List<WordItem>>

}