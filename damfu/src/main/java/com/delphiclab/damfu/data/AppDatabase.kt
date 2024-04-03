package com.delphiclab.damfu.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.delphiclab.damfu.data.dao.EmojiDao
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@Database(entities = [DamfuEmojiEntity::class], version = 1, exportSchema = false)
@TypeConverters(AppTypeConvertor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun emojiDao(): EmojiDao
}