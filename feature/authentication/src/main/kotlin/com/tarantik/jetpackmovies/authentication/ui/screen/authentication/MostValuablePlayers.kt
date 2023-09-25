package com.tarantik.jetpackmovies.authentication.ui.screen.authentication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density

@Composable
fun MostValuablePlayers(
    valueHeader: @Composable () -> Unit,
    rowCount: Int,
    nameLabel: @Composable (index: Int) -> Unit,
    valueBar: @Composable (index: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameLabels = @Composable {
        repeat(rowCount) {
            nameLabel(it)
        }
    }
    val valueBars = @Composable {
        repeat(rowCount) {
            valueBar(it)
        }
    }

    Layout(
        contents = listOf(valueHeader, nameLabels, valueBars),
        modifier = modifier,
    ) {
        (valueHeaderMeasurables, nameLabelMeasurables, valueBarsMeasurables), constraints ->
        val valueHeaderPlaceable = valueHeaderMeasurables.first().measure(constraints)
        var height = valueHeaderPlaceable.height
        val nameLabelPlaceables = nameLabelMeasurables.map {measurable ->
            val placeable = measurable.measure(constraints)
            height += placeable.height
            placeable
        }

        val valueWidth = valueHeaderPlaceable.width / nameLabelMeasurables.size

        val barPlaceables = valueBarsMeasurables.map { measurable ->
            val barParentData = measurable.parentData as PlayersGraphParentData
            val barWidth = valueHeaderPlaceable.width - barParentData.index * valueWidth

            val barPlaceable = measurable.measure(
                constraints.copy(
                    minWidth = barWidth,
                    maxWidth = barWidth,
                )
            )
            height += barPlaceable.height
            barPlaceable
        }

        layout(valueHeaderPlaceable.width + nameLabelPlaceables.first().width, height) {
            val xPosition = nameLabelPlaceables.first().width
            var yPosition = valueHeaderPlaceable.height

            valueHeaderPlaceable.place(xPosition, 0)

            barPlaceables.forEachIndexed { index, placeable ->
                placeable.place(xPosition, yPosition)
                val nameLabelPlaceable = nameLabelPlaceables[index]
                nameLabelPlaceable.place(x = 0, y = yPosition)

                yPosition += nameLabelPlaceable.height
            }
        }
    }
}

class PlayersGraphParentData(
    val index: Int
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): Any? =
        this@PlayersGraphParentData
}

fun Modifier.playerPriceBar(
    index: Int,
) = this.then(
    PlayersGraphParentData(
        index = index
    )
)

