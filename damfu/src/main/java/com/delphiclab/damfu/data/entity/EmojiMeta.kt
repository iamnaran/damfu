package com.delphiclab.damfu.data.entity

import androidx.annotation.IdRes

data class EmojiMeta(
    val id: Int? = null,
    val name: String,
    @IdRes
    val emoji: Int,
    val unicode: String,
    val emojiModelList: List<EmojiModel>
)