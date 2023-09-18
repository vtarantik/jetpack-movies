package com.tarantik.jetpackmovies

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tarantik.core.base.arch.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val content: @Composable () -> Unit = {
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        val density = LocalDensity.current
        var textWidth = 0.dp
//        Box(
//            modifier = Modifier
//                .background(Color.Magenta)
//                .size(100.dp)
//                .wrapContentSize()
//                .size(50.dp)
//                .fillMaxSize()
//                .size(20.dp)
//                .onGloballyPositioned {
//                    Timber.d("${with(density){it.size.width.}}")
//                }
//        ) {
//
//        }
        Text(
            text = "HELLO",
            modifier = Modifier
                .background(Color.Magenta)
                .padding(16.dp)
                .background(Color.Blue)
                .padding(48.dp)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }
}
