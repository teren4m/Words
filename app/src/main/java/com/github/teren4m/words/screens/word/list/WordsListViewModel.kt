package com.github.teren4m.words.screens.word.list

import androidx.databinding.ObservableArrayList
import com.github.teren4m.base.add
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.observeOnMain
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.words.screens.word.list.domain.IWordUseCase
import com.github.teren4m.words.screens.word.list.model.WordItem
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class WordsListViewModel
@Inject constructor(
    wordUseCase: IWordUseCase
) : BaseViewModel(), IWordsListViewModel {

    override val items = ObservableArrayList<WordItem>()

    init {
        wordUseCase.getAllWords()
            .map {
                it.map { word ->
                    WordItem.Hebrew(word) as WordItem
                }
            }
            .subscribeOnDefaultThread()
            .observeOnMain()
            .subscribeBy(
                onNext = {
                    items.clear()
                    items.addAll(it)
                }
            )
            .add(this)
    }
}