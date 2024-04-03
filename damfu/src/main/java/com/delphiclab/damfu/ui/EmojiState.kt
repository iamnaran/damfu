package com.delphiclab.damfu.ui

import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

data class EmojiState(
    val allEmojiList: List<DamfuEmojiEntity> = emptyList(),
    val loginErrorState: EmojiErrorState = EmojiErrorState()
)
data class EmojiErrorState(
    val errorState: ErrorState = ErrorState(),
)

data class ErrorState(
    val hasError: Boolean = false, val errorMessage: String = ""
)