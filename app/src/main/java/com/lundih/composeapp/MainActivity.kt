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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun SuperHeroCard(name: String, painter: Painter, ) {
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

            Text(modifier = Modifier.padding(8.dp),
                text = name,
                style = TextStyle(color = Color.White))
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