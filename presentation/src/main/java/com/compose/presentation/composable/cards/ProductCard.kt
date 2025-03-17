package com.compose.presentation.composable.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.presentation.R
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(165.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(CoffeeTheme.colors.secondaryBackground)
            .then(modifier),
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (favourite, image, title, price, description) = createRefs()
            Image(
                painter = painterResource(R.drawable.product_sample_1),
                modifier = Modifier
                    .size(100.dp)
                    .constrainAs(ref = image) {
                        top.linkTo(parent.top, 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            IconButton(onClick = {}, modifier = Modifier.constrainAs(favourite) {
                end.linkTo(price.end)
                start.linkTo(price.start)
            }) {
                Icon(
                    Icons.Default.FavoriteBorder,
                    tint = CoffeeTheme.colors.text,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = "Arabica",
                style = CoffeeTheme.typography.titleMedium,
                color = CoffeeTheme.colors.text,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                modifier = Modifier
                    .width(100.dp)
                    .constrainAs(title) {
                        start.linkTo(parent.start, 15.dp)
                        top.linkTo(image.bottom)
                    })
            Text(
                text = "$18",
                style = CoffeeTheme.typography.labelSmall,
                color = CoffeeTheme.colors.text,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                modifier = Modifier.constrainAs(price) {
                    bottom.linkTo(title.bottom)
                    top.linkTo(title.top)
                    end.linkTo(parent.end, 15.dp)
                })
            Text(
                text = "Lorem ipsum dolor sit amet cons",
                style = CoffeeTheme.typography.labelSmall,
                color = CoffeeTheme.colors.text,
                fontSize = 9.sp,
                lineHeight = 9.sp,
                modifier = Modifier
                    .width(100.dp)
                    .constrainAs(description) {
                        start.linkTo(parent.start, 15.dp)
                        top.linkTo(title.bottom, 5.dp)
                    })
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    CoffeeTheme {
        ProductCard()
    }
}