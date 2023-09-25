package com.tarantik.jetpackmovies

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.tarantik.core.base.arch.BaseActivity
import com.tarantik.jetpackmovies.authentication.nav.AuthenticationActivity
import com.tarantik.jetpackmovies.authentication.ui.screen.authentication.FootballField
import com.tarantik.jetpackmovies.authentication.ui.screen.authentication.MostValuablePlayers
import com.tarantik.jetpackmovies.authentication.ui.screen.authentication.SoccerField
import com.tarantik.jetpackmovies.authentication.ui.screen.authentication.playerPriceBar
import com.tarantik.jetpackmovies.nav.MainNavigation
import com.tarantik.jetpackmovies.nav.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Immutable
data class FootballPlayer(
    val name: String,
    val value: Int,
)

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    val viewModel: MainViewModel by viewModels<MainViewModel>()

    override val content: @Composable () -> Unit = {

//        MoviesListScreen(hiltViewModel())
//        Animations()
//        MainNavigation()
        val players = listOf(
            FootballPlayer(
                name = "Haaland",
                value = 262,
            ),
            FootballPlayer(
                name = "Vinicius Jr.",
                value = 210,
            ),
            FootballPlayer(
                name = "Saka",
                value = 209,
            ),
            FootballPlayer(
                name = "Bellingham",
                value = 203,
            ),
            FootballPlayer(
                name = "Rodrygo",
                value = 197,
            ),
            FootballPlayer(
                name = "Pedri",
                value = 190,
            ),
            FootballPlayer(
                name = "Gavi",
                value = 186,
            ),
            FootballPlayer(
                name = "Musiala",
                value = 182,
            ),
            FootballPlayer(
                name = "Foden",
                value = 178,
            ),
            FootballPlayer(
                name = "Mbappe",
                value = 174,
            )
        )

//        MostValuablePlayers(
//            valueHeader = {
//                Row {
//                    players.reversed().forEach {
//                        Text(
//                            textAlign = TextAlign.Center,
//                            text = it.value.toString(),
//                            modifier = Modifier.width(50.dp)
//                        )
//                    }
//                }
//            },
//            rowCount = players.size,
//            nameLabel = {
//                Text(
//                    text = players[it].name,
//                    modifier = Modifier
//                        .width(80.dp)
//                        .height(24.dp)
//                )
//            },
//            valueBar = {
//                Spacer(
//                    modifier = Modifier
//                        .height(20.dp)
//                        .background(Color.Blue)
//                        .playerPriceBar(it)
//                )
//            },
//            modifier = Modifier
//                .horizontalScroll(rememberScrollState())
//        )

        Box(
            modifier = Modifier
                .systemBarsPadding()
        ) {
            SoccerField(
                fieldWidth = 400.dp,
                shots = listOf(200f to 40f),
                goals = listOf(true)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
//
//        if (viewModel.isUserAuthenticated().not()) {
//            startActivity(AuthenticationActivity.newIntent(this))
//        }
    }
}
