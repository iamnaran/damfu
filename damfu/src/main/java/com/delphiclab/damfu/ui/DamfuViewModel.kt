package com.delphiclab.damfu.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delphiclab.damfu.data.DatabaseManager
import com.delphiclab.damfu.data.dto.EmojiByCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DamfuViewModel : ViewModel() {

    private val _emojisState = MutableStateFlow<List<EmojiByCategory>>(emptyList())
    val emojisState: Flow<List<EmojiByCategory>> = _emojisState

    public fun fetchEmoji(context: Context) {
        viewModelScope.launch {
            DatabaseManager.getInstance(context).getAllEmojisFlow().collect { emojis ->
                val groupedEmojis = emojis.groupBy { it.categoryName }
                    .map { (categoryName, emojis) -> EmojiByCategory(categoryName, emojis) }
                _emojisState.value = groupedEmojis
            }
        }
    }

}