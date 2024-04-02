package com.delphiclab.damfu.data.repo

import com.delphiclab.damfu.data.entity.DamfuEmojiMeta
import kotlinx.coroutines.flow.Flow

interface EmojiRepositoryImpl {

    suspend fun getAllEmoji(): Flow<DamfuEmojiMeta>

}