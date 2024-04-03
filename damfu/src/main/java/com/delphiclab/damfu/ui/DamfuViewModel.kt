package com.delphiclab.damfu.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delphiclab.damfu.data.DatabaseManager
import com.delphiclab.damfu.data.dto.EmojiByCategory
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DamfuViewModel : ViewModel() {

    private val _emojisState = MutableStateFlow<List<EmojiByCategory>>(emptyList())
    val emojisState: Flow<List<EmojiByCategory>> = _emojisState

    private val _emojisMapState = MutableStateFlow<Map<String, List<DamfuEmojiEntity>>>(emptyMap())
    val emojisMapState: Flow<Map<String, List<DamfuEmojiEntity>>> = _emojisMapState


    public fun fetchEmoji(context: Context) {
        viewModelScope.launch {
            DatabaseManager.getInstance(context).getAllEmojisFlow().collect { emojis ->
                val groupedEmojis = emojis.groupBy { it.categoryName }
                    .map { (categoryName, emojis) -> EmojiByCategory(categoryName, emojis) }
                _emojisState.value = groupedEmojis
            }
        }
    }

    fun fetchMapEmojis(context: Context) {
        viewModelScope.launch {
            DatabaseManager.getInstance(context).getAllEmojisFlow().collectLatest { emojis ->
                val groupedEmojis = emojis.groupBy { it.categoryName }
                _emojisMapState.value = groupedEmojis
            }
        }
    }

}