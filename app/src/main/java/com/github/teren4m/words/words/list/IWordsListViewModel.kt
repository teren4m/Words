package com.github.teren4m.words.words.list

import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.mvvm.ActionLiveEvent
import com.github.teren4m.words.words.list.model.WordItem

interface IWordsListViewModel {

    val wordsList: MutableLiveData<List<WordItem>>
    val onCreate: ActionLiveEvent

    fun create()

    fun update()
}