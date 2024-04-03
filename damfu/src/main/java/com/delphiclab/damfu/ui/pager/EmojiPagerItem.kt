package com.delphiclab.damfu.ui.pager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
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
fun EmojiPagerItem(emojiList: List<DamfuEmojiEntity>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(30.dp),
        modifier = Modifier.wrapContentHeight()
    ) {
        items(emojiList.size) { index ->
            Box(modifier = Modifier.aspectRatio(1f)) {
                Text(text = emojiList[index].emoji, style = TextStyle(fontSize = 14.sp))
            }
        }
    }

}