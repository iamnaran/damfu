package com.delphiclab.damfu.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface  EmojiDao {

    @Query("SELECT * FROM emojis")
    fun getAllEmoji(): Flow<DamfuEmojiEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEmoji(emojis: List<DamfuEmojiEntity>)
    @Query("SELECT * FROM emojis")
    fun getAllEmojisFlow(): Flow<List<DamfuEmojiEntity>>

}