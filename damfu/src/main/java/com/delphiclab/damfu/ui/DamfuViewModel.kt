package com.delphiclab.damfu.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.delphiclab.damfu.data.DatabaseManager
import com.delphiclab.damfu.data.entity.EmojiModel
import com.delphiclab.damfu.utils.EmojiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DamfuViewModel : ViewModel() {


    private val _emojiState = MutableStateFlow(EmojiState())
    val emojiState = _emojiState.asStateFlow()

    init {

    }

    fun getAllEmojiList(context: Context) {

        DatabaseManager.getInstance(context).emojiDao().getAllEmoji()

    }

    suspend fun insertAllEmoji(context: Context, allEmoji: List<EmojiModel>) {
        val emojiDao = DatabaseManager.getInstance(context).emojiDao()
        val emojiEntities = allEmoji.map { EmojiMapper.mapToEntity(it) }
        emojiDao.insertAllEmoji(emojiEntities)
    }

}