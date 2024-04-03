package com.delphiclab.damfu.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@Composable
fun EmojiRowItem(categoryName: String, emojiList: List<DamfuEmojiEntity>) {


    Column {
        Text(text = categoryName)

        LazyVerticalGrid(
            columns = GridCells.Adaptive(50.dp),
        ) {
            items(emojiList.size) { index ->
                Box(
                    modifier = Modifier.aspectRatio(1f)
                ) {
                    Text(text = emojiList[index].emoji)
                }
            }
        }
    }

}