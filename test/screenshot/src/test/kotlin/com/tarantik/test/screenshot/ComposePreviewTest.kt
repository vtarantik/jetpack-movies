package com.tarantik.test.screenshot

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.tarantik.core.test.ScreenshotTest
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith

class ComponentPreview(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    val content: @Composable () -> Unit = showkaseBrowserComponent.component
    override fun toString(): String = showkaseBrowserComponent.group + ":" + showkaseBrowserComponent.componentName
}

@Category(ScreenshotTest::class)
@RunWith(TestParameterInjector::class)
class ComposePreviewTest {
    object PreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentPreview> =
            Showkase.getMetadata().componentList.map(::ComponentPreview)
    }

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
        deviceConfig = PIXEL_5.copy(softButtons = false),
    )

    @Test
    fun takeScreenshots(
        @TestParameter(valuesProvider = PreviewProvider::class) componentPreview: ComponentPreview,
//        @TestParameter(value = ["1.0", "1.5"]) fontScale: Float,
    ) {
        paparazzi.snapshot {
            val lifecycleOwner = LocalLifecycleOwner.current
            CompositionLocalProvider(
                // Needed so that UI that uses it don't crash during screenshot tests
                LocalOnBackPressedDispatcherOwner provides object : OnBackPressedDispatcherOwner {
                    override val lifecycle: Lifecycle = lifecycleOwner.lifecycle
                    override val onBackPressedDispatcher: OnBackPressedDispatcher = OnBackPressedDispatcher()
                },
                LocalInspectionMode provides true,
//                LocalDensity provides Density(
//                    density = LocalDensity.current.density,
//                    fontScale = fontScale
//                )
            ) {
                componentPreview.content()
            }
        }
    }
}
