package com.delphiclab.damfu.data

import android.content.Context
import androidx.room.Room
import com.delphiclab.damfu.data.dao.EmojiDao
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity
import kotlinx.coroutines.flow.Flow

class DatabaseManager private constructor(private val appDatabase: AppDatabase) {

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
                    )
                        .addCallback(PreDamfuDbCallback(context))
                        .fallbackToDestructiveMigration().build()
                    DatabaseManager(db).also { INSTANCE = it }
                }
            }
        }
    }

    fun emojiDao(): EmojiDao {
        return appDatabase.emojiDao()
    }

    fun getAllEmojisFlow(): Flow<List<DamfuEmojiEntity>> {
        return appDatabase.emojiDao().getAllEmojisFlow()
    }


}