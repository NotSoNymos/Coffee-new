package com.compose.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.presentation.theme.CoffeeTheme
import com.compose.presentation.theme.Grey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Configuration for an [InputField].
 *
 * @param containerColor base background color. Overrides background color of textFieldColor and being used inside row's modifier.
 * @param textFieldColors textFieldDefaults that are used for textField. Container and indicator colors are being overridden.
 * @param paddingValues padding for text. Recommended value is 20.dp from start.
 **/

@Immutable
class InputFieldOptions(
    val containerColor: Color = Color.Unspecified,
    val textFieldColors: TextFieldColors? = null,
    val paddingValues: PaddingValues = PaddingValues()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is InputFieldOptions) return false

        if (containerColor != other.containerColor) return false
        if (textFieldColors != other.textFieldColors) return false
        if (paddingValues != other.paddingValues) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + textFieldColors.hashCode()
        result = 31 * result + paddingValues.hashCode()
        return result
    }
}

/**
 * High level element that uses Row with TextField to slightly improve final appearance.
 *
 * @param value mutable variable that represents current text. Should be in viewmodel or screen state.
 * @param options instance of [InputFieldOptions] that contains background color, [PaddingValues] and [TextFieldColors] of element.
 * @param modifier modifier that should contain [Modifier.height] and [Modifier.width] or other size definition to work correctly.
 * @param shape row will be clipped to that shape.
 * @param placeholder placeholder text to appear when no user input presents.
 * @param onValueChange should contain an update function for [value].
 *
 * @sample InputFieldSample
 */

@Composable
fun InputField(
    value: String,
    options: InputFieldOptions,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    placeholder: String = "",
    onValueChange: (String) -> Unit
) {
    val containerColor = options.containerColor
    Row(
        modifier = modifier.then(
            Modifier
                .clip(shape)
                .background(containerColor)
        ), verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(value = value,
            modifier = Modifier
                .padding(options.paddingValues)
                .fillMaxWidth(),
            colors = (options.textFieldColors ?: TextFieldDefaults.colors()).copy(
                unfocusedContainerColor = containerColor,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = containerColor,
                focusedIndicatorColor = Color.Transparent,
            ),
            onValueChange = onValueChange,
            textStyle = CoffeeTheme.typography.displaySmall,
            placeholder = {
                Text(
                    placeholder,
                    style = CoffeeTheme.typography.displaySmall,
                )
            })
    }
}

@Stable
internal class InputFieldSample {

    class SampleViewModel {
        private val _state = MutableStateFlow(SampleState())

        val state: StateFlow<SampleState>
            get() = _state.asStateFlow()

        fun setText(data: String) {
            _state.value = _state.value.copy(data = data)
        }
    }

    data class SampleState(
        var data: String = ""
    )

    @Preview
    @Composable
    private fun InputFieldPreview() {
        val sampleViewModel = SampleViewModel()
        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
            Column {
                InputField(
                    value = sampleViewModel.state.collectAsState().value.data,
                    options = InputFieldOptions(
                        containerColor = Grey,
                        paddingValues = PaddingValues(start = 20.dp)
                    ),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth(),
                    placeholder = "E-mail Address",
                    onValueChange = sampleViewModel::setText
                )
            }
        }
    }
}
