package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

private val list = listOf(
    PlaylistModel(
        image = R.drawable.image_1,
        title = "Emotional Well-being & Healing Practices for Children",
        description = "32 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_2,
        title = "Self Care Before Child Care",
        description = "18 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_3,
        title = "Make a Life Changing Difference in a Child’s Life",
        description = "12 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_4,
        title = "Prevent & Respond to Sexual Abuse",
        description = "8 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_5,
        title = "Child Protection 101",
        description = "15 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_1,
        title = "Meet Nutritional Needs ",
        description = "11 video series"
    ),
    PlaylistModel(
        image = R.drawable.image_1,
        title = "Meet Nutritional Needs ",
        description = "11 video series"
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FirstScreen(list)
                }
            }
        }
    }
}

data class PlaylistModel(
    val image: Int,
    val title: String,
    val description: String
)

@Composable
fun FirstScreen(playlistList: List<PlaylistModel>) {
    LazyColumn {
        itemsIndexed(playlistList) { _, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(4),
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp)
                ) {
                    Box(modifier = Modifier.width(120.dp)) {
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .background(
                                    androidx.compose.ui.graphics.Color.Black.copy(
                                        alpha = 0.8f
                                    )
                                )
                                .height(24.dp)
                                .fillMaxWidth()
                                .align(alignment = Alignment.BottomCenter)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp),
                                text = "playlist",
                                color = androidx.compose.ui.graphics.Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(alignment = Alignment.CenterVertically)
                ) {
                    Text(
                        text = item.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = item.description,
                        fontSize = 12.sp
                    )

                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun YoutubePreview() {
    FirstScreen(
        playlistList = list
    )
}