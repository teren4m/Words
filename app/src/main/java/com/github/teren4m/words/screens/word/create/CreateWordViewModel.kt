package com.github.teren4m.words.screens.word.create

import androidx.databinding.ObservableField
import com.github.teren4m.base.add
import com.github.teren4m.base.mvvm.ActionLiveEvent
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.observeOnMain
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.words.screens.word.list.domain.IWordUseCase
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CreateWordViewModel @Inject constructor(
    private val createWordUseCase: IWordUseCase
) : BaseViewModel(), ICreateWordViewModel {

    override val onBack = ActionLiveEvent()

    override val word = ObservableField<String>("1")

    override val transcription = ObservableField<String>("1")

    override val root = ObservableField<String>("1")

    override val partOfSpeech = ObservableField<String>("1")

    override val translation = ObservableField<String>("1")

    override fun create() {
        createWordUseCase.createWord(
            word = word.get(),
            transcription = transcription.get(),
            root = root.get(),
            partOfSpeech = partOfSpeech.get(),
            translation = translation.get()
        )
            .subscribeOnDefaultThread()
            .observeOnMain()
            .subscribeBy(
                onComplete = ::onComplete,
                onError = ::onError
            )
            .add(this)
    }

    private fun onComplete() {
        onBack.call()
    }

    private fun onError(t: Throwable) {
        t.toString()
    }
}