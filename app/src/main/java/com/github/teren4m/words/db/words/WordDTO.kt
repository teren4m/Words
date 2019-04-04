package com.github.teren4m.words.db.words

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.teren4m.words.Uuid

@Entity
data class WordDTO(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    var uuid: Uuid,

    @ColumnInfo(name = "word")
    var word: String,

    @ColumnInfo(name = "transcription")
    var transcription: String,

    @ColumnInfo(name = "root")
    var root: String,

    @ColumnInfo(name = "part_of_speech")
    var partOfSpeech: String,

    @ColumnInfo(name = "translation")
    var translation: String
)