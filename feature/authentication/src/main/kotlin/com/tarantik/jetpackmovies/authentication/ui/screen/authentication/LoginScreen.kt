package com.tarantik.jetpackmovies.authentication.ui.screen.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.tarantik.core.base.arch.LocalActivity
import com.tarantik.core.base.theme.JetpackMoviesTheme
import com.tarantik.jetpackmovies.authentication.composable.EditableInput
import com.tarantik.jetpackmovies.authentication.composable.EditableInputType

interface LoginScreenListener {
    fun onLoginClick()
}

@Composable
fun LoginScreen() {
    val activity = LocalActivity.current
    val focusRequester = remember {
        FocusRequester()
    }

    val listener = remember(activity) {
        object : LoginScreenListener {
            override fun onLoginClick() {activity.finish()}
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .imePadding()
    ) {
        EditableInput(
            modifier = Modifier
                .focusRequester(focusRequester)
        )

        Spacer(modifier = Modifier.height(16.dp))

        EditableInput(
            type = EditableInputType.Password
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = listener::onLoginClick
        ) {
            Text(
                text =  "Login",
                color = JetpackMoviesTheme.colors.onSurface.secondary
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}