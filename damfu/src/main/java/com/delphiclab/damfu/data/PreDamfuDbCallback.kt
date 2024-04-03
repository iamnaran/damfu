package com.delphiclab.damfu.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.delphiclab.damfu.utils.AppLog
import com.delphiclab.damfu.utils.CommonUtils
import com.delphiclab.damfu.utils.EmojiMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PreDamfuDbCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            prePopulateEmojis(context)
        }
    }

    private suspend fun prePopulateEmojis(context: Context) {

        try {
            val loadedEmojiList = withContext(Dispatchers.IO) {
                CommonUtils.loadEmojiData(context)
            }
            val emojiDao = DatabaseManager.getInstance(context).emojiDao()
            val emojiEntities = loadedEmojiList.map { EmojiMapper.mapToEntity(it) }
            emojiDao.insertAllEmoji(emojiEntities)

        } catch (exception: Exception) {
            AppLog.showLog(
                ("Damfu App" +
                        exception.localizedMessage) ?: "error in pre-populate database"
            )
        }
    }
}