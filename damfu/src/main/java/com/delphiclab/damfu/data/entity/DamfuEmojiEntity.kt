package com.delphiclab.damfu.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emojis")
data class DamfuEmojiEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val emoji: String,
    val unicode: String,
    val score: Int,
    val categoryId: Int,
    val categoryName: String,
    val subCategoryId: Int,
    val subCategoryName: String,
    val keywords: List<String>
)