package com.tarantik.jetpackmovies.authentication.nav

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import com.tarantik.core.base.arch.BaseActivity
import com.tarantik.jetpackmovies.authentication.ui.screen.authentication.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity: BaseActivity() {
    companion object {
        fun newIntent(context: Context) = Intent(context, AuthenticationActivity::class.java)
    }

    override val content: @Composable () -> Unit = {
        LoginScreen()
    }
}