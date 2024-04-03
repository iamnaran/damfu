package com.delphiclab.damfu.utils

import android.content.Context
import com.delphiclab.damfu.R
import com.delphiclab.damfu.data.dto.EmojiModel
import kotlinx.serialization.json.Json
import java.io.IOException
import java.io.InputStream

class CommonUtils {

    companion object{
        fun loadEmojiData(context: Context): List<EmojiModel> {
            val emojiList = mutableListOf<EmojiModel>()
            try {
                val jsonString = loadJSONFromAsset(context)
                val emojiArray = decodeJsonString<List<EmojiModel>>(jsonString)
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

        private val json = Json {
            ignoreUnknownKeys = true
        }

        fun <T> loadJSONFromAsset(inputStream: InputStream): String {
            return inputStream.bufferedReader().use { it.readText() }
        }

        private inline fun <reified T> decodeJsonString(jsonString: String): T {
            return json.decodeFromString<T>(jsonString)
        }
    }


}