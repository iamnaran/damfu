package com.delphiclab.damfu.ui.sticky

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun EmojiHStickyList(emojiMapList: Map<String, List<DamfuEmojiEntity>>) {

    LazyRow() {
        emojiMapList.map { (category, emojis) ->
            stickyHeader {
                Text(text = category)
            }

            item {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(5),
                    modifier = Modifier.width(400.dp)
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
//                FlowColumn(
//                    modifier = Modifier.padding(20.dp),
//                    verticalArrangement = Arrangement.SpaceEvenly,
//                    maxItemsInEachColumn = 5
//
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