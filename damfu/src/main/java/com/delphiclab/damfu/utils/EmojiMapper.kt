package com.delphiclab.damfu.utils

import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import com.delphiclab.damfu.data.entity.EmojiModel

object EmojiMapper {
    fun mapToEntity(emojiModel: EmojiModel): DamfuEmojiEntity {
        return DamfuEmojiEntity(
            id = emojiModel.id,
            name = emojiModel.name,
            emoji = emojiModel.emoji,
            unicode = emojiModel.unicode,
            score = emojiModel.score,
            categoryId = emojiModel.category.id,
            subCategoryId = emojiModel.subCategory.id,
            keywords = emojiModel.keywords
        )
    }
}