package com.github.teren4m.words.screens.word.data.converters

import com.github.teren4m.words.db.words.WordDTO
import com.github.teren4m.words.screens.word.data.model.Word
import javax.inject.Inject

class WordToWordDTOConverter @Inject constructor() : IWordToWordDTOConverter {
    override fun convert(word: Word): WordDTO =
        WordDTO(
            uuid = word.uuid,
            word = word.word,
            transcription = word.transcription,
            root = word.root,
            partOfSpeech = word.partOfSpeech,
            translation = word.translation
        )

}