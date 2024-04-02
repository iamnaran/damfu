package com.damfu.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import com.damfu.sample.ui.theme.DamfuSampleTheme
import com.delphiclab.damfu.ui.dialog.DamfuEmojiPicker
import com.delphiclab.damfu.ui.dialog.container.DamfuContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DamfuSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var showEmojiModalSheet by remember { mutableStateOf(false) }

    Button(
        onClick = { showEmojiModalSheet = true },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Open Emoji Picker")
    }

    if (showEmojiModalSheet) {
        DamfuEmojiPicker(
            onDismiss = { showEmojiModalSheet = false }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DamfuSampleTheme {
        Greeting("Android")
    }
}