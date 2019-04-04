package com.github.teren4m.words.words.list

import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.add
import com.github.teren4m.base.mvvm.ActionLiveEvent
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.observeOnMain
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.words.words.list.domain.IWordUseCase
import com.github.teren4m.words.words.list.model.WordItem
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class WordsListViewModel
@Inject constructor(
    private val wordUseCase: IWordUseCase
) : BaseViewModel(), IWordsListViewModel {

    override val wordsList = MutableLiveData<List<WordItem>>()

    override val onCreate = ActionLiveEvent()

    override fun create() {
        onCreate.call()
    }

    override fun update() {
        wordUseCase.getAllWords()
            .map {
                it.map { word ->
                    WordItem.Hebrew(word) as WordItem
                }
            }
            .subscribeOnDefaultThread()
            .observeOnMain()
            .subscribeBy(
                onSuccess = {
                    onSuccess(it)
                }
            )
            .add(this)
    }

    private fun onSuccess(list: List<WordItem>) {
        wordsList.value = list
    }
}