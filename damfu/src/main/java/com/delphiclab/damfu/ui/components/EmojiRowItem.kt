package com.delphiclab.damfu.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@Composable
fun EmojiRowItem(emojiList1: String, emojiList: List<DamfuEmojiEntity>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(45.dp),
        modifier = Modifier.wrapContentHeight(),
        verticalArrangement = Arrangement.Center
    ) {

        items(emojiList.size) { index ->
            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = emojiList[index].categoryName,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 10.sp)
                )
                Box(modifier = Modifier.aspectRatio(1f)) {
                    Text(text = emojiList[index].emoji)
                }
            }

        }
    }

}