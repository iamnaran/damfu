package com.delphiclab.damfu.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.delphiclab.damfu.data.dao.EmojiDao
import com.delphiclab.damfu.data.entity.EmojiModel

@Database(entities = [EmojiModel::class], version = 1, exportSchema = false)
@TypeConverters(AppTypeConvertor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun emojiDao(): EmojiDao


}