@file:OptIn(ExperimentalAnimationApi::class)

package com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarantik.jetpackmovies.feature.movieslist.R

@Composable
fun Animations() {
    Column(
        modifier = Modifier
            .systemBarsPadding()
    ) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        var isRound by remember {
            mutableStateOf(false)
        }

        Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text("Toggle animation")
        }

//        val borderRadius by animateDpAsState(
//            label = "Border animation",
//            targetValue = if(isRound) 40.dp else 8.dp,
//            animationSpec = keyframes {
//
//            }
//        )

//        val transition = updateTransition(
//            targetState = isRound,
//            label = "Update Transition"
//        )
//
//        val borderRadius by transition.animateDp(
//            label = "Radius",
//            transitionSpec = { tween(2000) },
//            targetValueByState = {round ->
//                if(round) 40.dp else 8.dp
//            }
//        )
//
//        val offset by transition.animateDp(
//            label = "Offset",
//            transitionSpec = { tween(1000) },
//            targetValueByState = {round ->
//                if(round) 20.dp else 0.dp
//            }
//        )

//        val transition = rememberInfiniteTransition()
//        val angle by transition.animateFloat(
//            initialValue = 0f,
//            targetValue = 1f,
//            animationSpec = infiniteRepeatable(
//                animation = tween(2000),
//                repeatMode = RepeatMode.Reverse,
//            )
//        )

        AnimatedContent(
            targetState = isVisible,
            label = "Animated content",
            modifier = Modifier
                .fillMaxSize(),
            content = {visible ->
                if(visible) {
                    Box(
                      modifier = Modifier.background(Color.Magenta)
                    ) {
                        Image(painter = painterResource(id = com.tarantik.core.base.R.drawable.img_poster),
                            contentDescription = null)
                    }
                } else {
                    Box(modifier = Modifier.background(Color.Blue)) {
                        Image(painter = painterResource(id = com.tarantik.core.base.R.drawable.img_poster),
                            contentDescription = null)
                    }
                }
            },
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = {
                        -it/2
                    }
                ) with slideOutHorizontally(
                    targetOffsetX = {
                        it/2
                    }
                )
            }
        )


//        AnimatedVisibility(
//            visible = isVisible,
//            enter = slideInHorizontally()
//        ) {
//            MoviePoster()
//        }
//
//        MoviePoster(
//            angle = angle,
//        )
    }
}

@Composable
fun MoviePoster(
    angle: Float,
) {
    Image(
        painter = painterResource(id = com.tarantik.core.base.R.drawable.img_poster),
        contentDescription = null,
        modifier = Modifier
            .rotate(
                degrees = 360 * angle,
            ),
        contentScale = ContentScale.Crop,
    )
}
