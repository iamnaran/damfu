package com.delphiclab.damfu.data.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmojiModel(
    val id: Int,
    val name: String,
    val emoji: String,
    val unicode: String,
    val score: Int,
    val category: Category,
    @SerialName("sub_category")
    val subCategory: SubCategory,
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