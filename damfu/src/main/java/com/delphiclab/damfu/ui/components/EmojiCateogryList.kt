package com.delphiclab.damfu.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delphiclab.damfu.data.dto.EmojiByCategory

@Composable
fun EmojiCategoryList(emojiList: List<EmojiByCategory>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(emojiList.size) { index ->
            Column(modifier = Modifier.height(200.dp)) {
                Text(
                    text = emojiList[index].categoryName,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 10.sp)
                )
                EmojiRowItem(emojiList[index].emojis)
            }

        }
    }

}