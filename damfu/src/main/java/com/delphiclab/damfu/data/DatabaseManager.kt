package com.delphiclab.damfu.data

import android.content.Context
import androidx.room.Room
import com.delphiclab.damfu.data.core.AppDatabase
import com.delphiclab.damfu.data.entity.EmojiModel
import kotlinx.coroutines.flow.Flow

class DatabaseManager private constructor(private val appDatabase: AppDatabase) {
    fun getAllEmoji(): Flow<EmojiModel> {
        return appDatabase.emojiDao().getAllEmoji()
    }

    companion object {
        @Volatile
        private var INSTANCE: DatabaseManager? = null

        @JvmStatic
        fun getInstance(context: Context): DatabaseManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: run {
                    val db = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, "x_damfu_x"
                    ).fallbackToDestructiveMigration().build()
                    DatabaseManager(db).also { INSTANCE = it }
                }
            }
        }
    }
}