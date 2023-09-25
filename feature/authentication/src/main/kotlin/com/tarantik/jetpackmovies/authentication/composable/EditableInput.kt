package com.tarantik.jetpackmovies.authentication.composable

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

sealed interface EditableInputType {
    data object Text: EditableInputType
    data object Password: EditableInputType
}

class EditableInputState(
    initialText: String,
) {
    var text by mutableStateOf(initialText)
        private set

    fun updateText(newText: String) {
        text = newText
    }

    companion object {
        val Saver: Saver<EditableInputState, *> = listSaver(
            save = {
                listOf(it.text)
            },
            restore = {
                EditableInputState(
                    initialText = it[0]
                )
            }
        )
    }
}

@Composable
fun rememberEditableInputState(initialText: String = ""): EditableInputState =
    rememberSaveable(
        saver = EditableInputState.Saver
    ) {
        EditableInputState(initialText = initialText)
    }

@Composable
fun EditableInput(
    modifier: Modifier = Modifier,
    state: EditableInputState = rememberEditableInputState(),
    type: EditableInputType = EditableInputType.Text,
) {
    TextField(
        value = state.text,
        onValueChange = {
            state.updateText(it)
        },
        visualTransformation = when(type) {
            is EditableInputType.Text -> VisualTransformation.None
            is EditableInputType.Password -> PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = when(type) {
                is  EditableInputType.Text -> KeyboardType.Text
                is EditableInputType.Password -> KeyboardType.Password
            }
        ),
        modifier = modifier
    )
}
