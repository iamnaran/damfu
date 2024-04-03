package com.damfu.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.damfu.sample.ui.theme.DamfuSampleTheme
import com.delphiclab.damfu.ui.DamfuEmojiPicker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DamfuSampleTheme {
                // A surface container using the 'background' color from the theme
                val context = LocalContext.current

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()) {

                        Greeting("Android", context)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, context: Context) {

    var showEmojiModalSheet by remember { mutableStateOf(false) }

    Button(
        onClick = { showEmojiModalSheet = true },
    ) {
        Text("Open Emoji Picker")
    }

    if (showEmojiModalSheet) {

        DamfuEmojiPicker(
            onDismiss = {


            }, context = context
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DamfuSampleTheme {
        Greeting("Android", LocalContext.current)
    }
}