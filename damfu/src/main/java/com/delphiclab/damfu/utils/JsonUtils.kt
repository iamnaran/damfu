package com.delphiclab.damfu.utils

import kotlinx.serialization.json.Json
import java.io.InputStream

object JsonUtils {

    val json = Json {
        ignoreUnknownKeys = true
    }

    fun <T> loadJSONFromAsset(inputStream: InputStream): String {
        return inputStream.bufferedReader().use { it.readText() }
    }

    inline fun <reified T> decodeJsonString(jsonString: String): T {
        return json.decodeFromString<T>(jsonString)
    }
}