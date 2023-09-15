@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarantik.jetpackmovies

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tarantik.core.base.arch.BaseActivity

class MainActivity : BaseActivity() {
    override val content: @Composable () -> Unit = {
        Box {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Text(text = "ASDASD")
}