package com.delphiclab.damfu.ui.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delphiclab.damfu.data.dto.EmojiByCategory
import com.delphiclab.damfu.ui.components.EmojiRowItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmojiCategoryPager(emojiByCategoryList: List<EmojiByCategory>) {

    val pagerState = rememberPagerState(pageCount = {
        emojiByCategoryList.size
    })
    VerticalPager(state = pagerState) { index ->
        Column {
            Text(
                text = emojiByCategoryList[index].categoryName,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 10.sp)
            )
            EmojiPagerItem(emojiByCategoryList[index].emojis)

        }

    }



}