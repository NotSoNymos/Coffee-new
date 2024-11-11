package com.compose.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.presentation.composable.DecoratedButtonType.Default
import com.compose.presentation.composable.DecoratedButtonType.Empty
import com.compose.presentation.theme.CoffeeTheme
import com.compose.presentation.theme.Golden

enum class DecoratedButtonType {
    Default, Empty
}


object DecoratedButtonValues {
    private val DefaultColors: ButtonColors
        @Composable get() = ButtonColors(
            //contentColor = Color.Black,
            contentColor = CoffeeTheme.colors.background,
            containerColor = CoffeeTheme.colors.primary,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified
        )

    private val EmptyColors: ButtonColors
        @Composable get() = ButtonColors(
            contentColor = Color.Transparent,
            containerColor = Color.Transparent,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified
        )


    private val EmptyTextColor = Golden
    private val EmptyModifier = Modifier.border(2.dp, Golden, shape = RoundedCornerShape(10.dp))

    @Composable
    fun getDefaultColor(type: DecoratedButtonType): ButtonColors {
        return when (type) {
            Default -> DefaultColors
            Empty -> EmptyColors
        }
    }

    @SuppressLint("ModifierFactoryExtensionFunction")
    @Composable
    fun getDefaultModifier(type: DecoratedButtonType): Modifier {
        return when (type) {
            Default -> Modifier
            Empty -> EmptyModifier
        }
    }

    @Composable
    fun getTextColor(type: DecoratedButtonType): Color {
        return when (type) {
            Default -> Color.Unspecified
            Empty -> EmptyTextColor
        }
    }
}

/**
 * High level element that utilizes [DecoratedButtonType] to obtain [DecoratedButtonValues] and use it's colors accordingly.
 *
 * Consists of a button with a text inside it. By fact that's just a wrapper to simplify reusing process.
 *
 * @param text text to display inside a button.
 *
 * @param modifier modifier that should contain [Modifier.height] and [Modifier.width] or other size definition to work correctly.
 *
 * @param buttonType instance of [DecoratedButtonType] that is used to obtain [ButtonColors] inside [DecoratedButtonValues].
 *
 * @param shape element will be clipped to that shape.
 *
 * @param onClick function to be invoked on button click.
 *
 * @sample [DecoratedButtonPreview]
 */
@Composable
fun DecoratedButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonType: DecoratedButtonType = Default,
    shape: Shape = RectangleShape,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.then(DecoratedButtonValues.getDefaultModifier(buttonType)),
        shape = shape,
        colors = DecoratedButtonValues.getDefaultColor(buttonType),
        onClick = onClick
    ) {
        Text(
            text,
            style = CoffeeTheme.typography.displayMedium,
            color = DecoratedButtonValues.getTextColor(buttonType)
        )
    }
}

@Preview
@Composable
private fun DecoratedButtonPreview() {
    CoffeeTheme {
        Column {
            //Filled button preset
            DecoratedButton(
                text = "Get Started",
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                buttonType = Default,
                shape = RoundedCornerShape(10.dp)
            ) {
                //...
            }
            //Empty button preset
            Spacer(modifier = Modifier.height(10.dp))
            DecoratedButton(
                text = "Get Started",
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                buttonType = Empty,
                shape = RoundedCornerShape(10.dp)
            ) {
                //...
            }
        }
    }

}