package com.example.risingimagecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.risingimagecard.model.IslandDataClass
import com.example.risingimagecard.ui.theme.RisingImageCardTheme
import com.example.risingimagecard.ui.theme.cardColorFive
import com.example.risingimagecard.ui.theme.cardColorFour
import com.example.risingimagecard.ui.theme.cardColorOne
import com.example.risingimagecard.ui.theme.cardColorThree
import com.example.risingimagecard.ui.theme.cardColorTwo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RisingImageCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val listOfIsland = listOf(IslandDataClass(1, "Bali", "Indonesia", cardColorOne, R.drawable.bali_icon),
        IslandDataClass(2, "Yosemite", "California", cardColorTwo, R.drawable.yosemite),
        IslandDataClass(3, "Rayyu", "Maldives", cardColorThree, R.drawable.rayyu_maldives),
        IslandDataClass(1, "Viti Levu", "Fiji", cardColorFour, R.drawable.viti_levu),
        IslandDataClass(1, "Beqa", "Fiji", cardColorFive, R.drawable.beqa)
    )

    Column(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
        ItemList(listOfIsland)
    }

}

@Composable
fun ItemList(itemList: List<IslandDataClass>) {
    LazyColumn {
        items(itemList) { item ->
            CardImageView(item)
        }
    }
}

@Composable
fun CardImageView(item: IslandDataClass) {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 3.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(top = 18.dp, bottom = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 72.dp, end = 18.dp, top = 21.dp)
                .fillMaxSize()
                .background(
                    color = item.color,
                    shape = RoundedCornerShape(20.dp),

                    )
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 16.dp, start = 81.dp)
                    .align(Alignment.TopStart)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = item.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.country,
                        color = Color(0xFFcfd8dc),

                    )
                }
            }
        }

        Image(
            painter = painterResource(id = item.resImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(0.35f)
                .padding(start = 18.dp)
                .clip(RoundedCornerShape(30.dp))
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush), RoundedCornerShape(30.dp)
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RisingImageCardTheme {
        Greeting()
    }
}