package com.delphiclab.damfu.ui.sticky

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.delphiclab.damfu.data.entity.DamfuEmojiEntity

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun EmojiHStickyList(emojiMapList: Map<String, List<DamfuEmojiEntity>>) {

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        emojiMapList.map { (category, emojis) ->
            stickyHeader {
                Text(text = category)
            }

            item {
                FlowColumn(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    maxItemsInEachColumn = 8

                ) {
                    emojis.map { emoji ->
                        Text(
                            text = emoji.emoji
                        )
                    }

                }
            }

        }


    }

}