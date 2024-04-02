package com.delphiclab.damfu.data.repo

import com.delphiclab.damfu.data.entity.EmojiMeta
import kotlinx.coroutines.flow.Flow

interface EmojiRepository {

    suspend fun getAllEmoji(): Flow<EmojiMeta>

}