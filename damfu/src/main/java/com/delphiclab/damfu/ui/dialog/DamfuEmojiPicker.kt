package com.delphiclab.damfu.ui.dialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.ui.dialog.container.DamfuEmojiContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DamfuEmojiPicker(
    onDismiss: () -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        DamfuEmojiContainer()
    }
}


//fun DamfuEmojiPicker(
//    onDismiss: () -> Unit,
//    content: @Composable () -> Unit
//) {
