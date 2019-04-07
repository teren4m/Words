package com.github.teren4m.words.screens.word.list

import androidx.databinding.ObservableArrayList
import com.github.teren4m.words.screens.word.list.model.WordItem

interface IWordsListViewModel {

    val items: ObservableArrayList<WordItem>

}