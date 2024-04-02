package com.delphiclab.damfu.data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "emojis")
@Serializable
data class EmojiModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val emoji: String,
    val unicode: String,
    val score: Int,
    val category: Category,
    val subCategory: SubCategory,
    val children: List<Children>,
    val keywords: List<String>
)

@Serializable
data class Category(
    val id: Int,
    val name: String
)

@Serializable
data class SubCategory(
    val id: Int,
    val name: String
)

@Serializable
data class Children(
    val id: Int,
    val name: String,
    val emoji: String,
    val unicode: String,
    val score: Int,
    val category: Category,
    val subCategory: SubCategory
)