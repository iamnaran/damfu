package com.delphiclab.damfu.ui

import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delphiclab.damfu.ui.components.EmojiList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DamfuEmojiPicker(
    onDismiss: () -> Unit,
    context: Context,
) {
    val damfuViewModel: DamfuViewModel = viewModel()
    val emojisList by damfuViewModel.emojisState.collectAsState(emptyList())

    val modalBottomSheetState = rememberModalBottomSheetState()

    LaunchedEffect(key1 = Unit) {
        damfuViewModel.fetchEmoji(context)
    }

    ModalBottomSheet(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {

        EmojiList(emojisList)
    }
}
