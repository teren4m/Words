package com.github.teren4m.words.words.create

import androidx.databinding.ObservableField
import com.github.teren4m.base.add
import com.github.teren4m.base.mvvm.ActionLiveEvent
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.observeOnMain
import com.github.teren4m.base.subscribeOnDefaultThread
import com.github.teren4m.words.words.list.domain.IWordUseCase
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CreateWordViewModel @Inject constructor(
    private val createWordUseCase: IWordUseCase
) : BaseViewModel(), ICreateWordViewModel {

    override val onBack = ActionLiveEvent()

    override val word = ObservableField<String>()

    override val transcription = ObservableField<String>()

    override val root = ObservableField<String>()

    override val partOfSpeech = ObservableField<String>()

    override val translation = ObservableField<String>()

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