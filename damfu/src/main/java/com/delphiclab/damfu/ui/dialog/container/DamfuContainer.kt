package com.delphiclab.damfu.ui.dialog.container

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delphiclab.damfu.data.entity.EmojiModel
import com.delphiclab.damfu.utils.AppLog
import com.delphiclab.damfu.utils.EmojiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun DamfuContainer() {

    val context = LocalContext.current
    val viewModel: DamfuViewModel = viewModel()
    var emojiList by remember { mutableStateOf<List<EmojiModel>>(emptyList()) }

    LaunchedEffect(Unit){

        val loadedEmojiList = withContext(Dispatchers.IO) {
            EmojiUtils.loadEmojiData(context)
        }
        emojiList = loadedEmojiList
        AppLog.showLog(emojiList.size.toString())

    }

}