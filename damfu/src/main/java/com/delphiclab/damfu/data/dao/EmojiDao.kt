package com.delphiclab.damfu.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface  EmojiDao {

    @Query("SELECT * FROM emojis")
    fun getAllEmoji(): Flow<DamfuEmojiEntity>

}