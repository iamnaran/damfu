package com.delphiclab.damfu.data.dto

import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

data class EmojiByCategory(
    val categoryName: String,
    val emojis: List<DamfuEmojiEntity>
)