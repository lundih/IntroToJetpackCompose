package com.lundih.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lundih.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppUI()
                }
            }
        }
    }
}

@Composable
fun AppUI () {
    Column {
        SuperHeroCard("Diana Prince", painterResource(R.drawable.image_dp))
        SuperHeroCard("Bruce Wayne", painterResource(R.drawable.image_bw))
        SuperHeroCard("Clark Kent", painterResource(R.drawable.image_ck))
        SuperHeroCard("Barry Allen", painterResource(R.drawable.image_ba))
        SuperHeroCard("Victor Stone", painterResource(R.drawable.image_vs))
        SuperHeroCard("Arthur Curry", painterResource(R.drawable.image_ac))
    }
}

@Composable
fun SuperHeroCard(name: String, painter: Painter) {
    val fontFamily = FontFamily(
        Font(R.font.genos_regular, FontWeight.Normal),
        Font(R.font.genos_bold, FontWeight.Bold))

    Card(modifier = Modifier
        .fillMaxWidth(0.5f)
        .height(200.dp)
        .padding(8.dp),
        shape = RoundedCornerShape(8.dp)) {

        Image(painter = painter,
            contentDescription = name,
            contentScale = ContentScale.Crop)

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart) {

            Text(
                modifier = Modifier.padding(8.dp),
                text = buildAnnotatedString {
                    append(name.split(" ")[0] + " ")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 28.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append(name.split(" ")[1])
                    }
                },
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        AppUI()
    }
}