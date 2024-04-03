package com.delphiclab.damfu.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delphiclab.damfu.data.DatabaseManager
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import com.delphiclab.damfu.data.entity.EmojiModel
import com.delphiclab.damfu.utils.EmojiMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DamfuViewModel : ViewModel() {

    private val _emojisState = MutableStateFlow<List<DamfuEmojiEntity>>(emptyList())
    val emojisState: Flow<List<DamfuEmojiEntity>> = _emojisState

    public fun fetchEmoji(context: Context) {
        viewModelScope.launch {
            DatabaseManager.getInstance(context).getAllEmojisFlow().collect { emojis ->
                _emojisState.value = emojis
            }
        }
    }

}