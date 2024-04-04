package com.delphiclab.damfu.ui.sticky

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun EmojiVStickyList(emojiMapList: Map<String, List<DamfuEmojiEntity>>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        emojiMapList.map { (category, emojis) ->
            stickyHeader {
                Text(text = category)
            }

            item {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(5),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(emojis.size) { index ->
                        Text(
                            text = emojis[index].emoji,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }

            }

//            item {
//                FlowRow(
//                    modifier = Modifier.padding(4.dp),
//                    horizontalArrangement = Arrangement.spacedBy(4.dp)
//                ) {
//                    emojis.map { emoji ->
//                        Text(
//                            text = emoji.emoji
//                        )
//                    }
//
//                }
//            }

        }


    }

}