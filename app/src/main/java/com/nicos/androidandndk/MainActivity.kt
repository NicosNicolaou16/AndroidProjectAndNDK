package com.nicos.androidandndk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nicos.androidandndk.ui.theme.AndroidAndNDKTheme

class MainActivity : ComponentActivity() {

    companion object {
        /**
         * Load the C file
         * */
        init {
            System.loadLibrary("message")
        }
    }

    /**
     * Initialize method from C file
     * */
    private external fun message(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAndNDKTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CallCFunction()
                }
            }
        }
    }

    @Composable
    fun CallCFunction(modifier: Modifier = Modifier) {
        var textMessage by rememberSaveable { mutableStateOf("") }
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = textMessage,
                    modifier = modifier,
                    textAlign = TextAlign.Center
                )
                Button(onClick = {
                    textMessage = message()
                }) {
                    Text(
                        text = "Click Here",
                        modifier = modifier
                    )
                }
            }
        }
    }
}