package com.delphiclab.damfu.utils

import android.content.Context
import com.delphiclab.damfu.R
import com.delphiclab.damfu.data.entity.EmojiModel
import java.io.IOException

class EmojiUtils {

    companion object{
        fun loadEmojiData(context: Context): List<EmojiModel> {
            val emojiList = mutableListOf<EmojiModel>()
            try {
                val jsonString = loadJSONFromAsset(context)
                val emojiArray = JsonUtils.decodeJsonString<List<EmojiModel>>(jsonString)
                emojiList.addAll(emojiArray)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return emojiList
        }

        private fun loadJSONFromAsset(context: Context): String {
            return try {
                val inputStream = context.resources.openRawResource(R.raw.damfu_emoji_json)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                String(buffer, Charsets.UTF_8)
            } catch (ex: IOException) {
                ex.printStackTrace()
                ""
            }
        }
    }


}