package com.delphiclab.damfu.ui

import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.data.entity.EmojiModel
import com.delphiclab.damfu.utils.AppLog
import com.delphiclab.damfu.utils.EmojiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DamfuEmojiPicker(
    onDismiss: () -> Unit,
    context: Context,
) {
    var emojiList by remember { mutableStateOf<List<EmojiModel>>(emptyList()) }
    val modalBottomSheetState = rememberModalBottomSheetState()

    LaunchedEffect(Unit) {
        val loadedEmojiList = withContext(Dispatchers.IO) {
            EmojiUtils.loadEmojiData(context)
        }
        emojiList = loadedEmojiList
        AppLog.showLog(emojiList.size.toString())

    }

    ModalBottomSheet(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Text("Hello Dialog")
    }
}


//fun DamfuEmojiPicker(
//    onDismiss: () -> Unit,
//    content: @Composable () -> Unit
//) {
