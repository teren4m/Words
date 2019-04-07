package com.github.teren4m.words.words.list

import androidx.databinding.ObservableArrayList
import com.github.teren4m.words.words.list.model.WordItem

interface IWordsListViewModel {

    val items: ObservableArrayList<WordItem>

}