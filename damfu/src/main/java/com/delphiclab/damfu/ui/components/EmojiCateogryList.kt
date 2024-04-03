package com.delphiclab.damfu.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delphiclab.damfu.data.dto.EmojiByCategory

@Composable
fun EmojiCategoryList(emojiList: List<EmojiByCategory>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(emojiList.size) { index ->
            Column(
                modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
            ) {
                EmojiRowItem(emojiList[index].categoryName, emojiList[index].emojis)
            }

        }
    }

}