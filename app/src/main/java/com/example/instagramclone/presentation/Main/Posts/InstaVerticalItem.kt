package com.example.instagramclone.presentation.Main.Posts

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.instagramclone.presentation.Main.Profile.components.RoundedImage
import com.example.instagramclone.presentation.Toast
import com.example.instagramclone.ui.theme.Shapes

@Composable
fun InstaVerticalItem(
    name: String,
    img: String,
    post: String,
    likeCount: Int,
    commentCount: Int,
    time: Long
) {
    val colorList = listOf(
        Color.Red,
        Color.Red,
        Color.Yellow,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                elevation = 4.dp,
                shape = Shapes.large,
                modifier = Modifier,
                border = BorderStroke(1.dp, brush = Brush.linearGradient(colors = colorList))
            ) {
                RoundedImage(
                    image = rememberImagePainter(data = img),
                    modifier = Modifier
                        .size(80.dp)
                )
            }
            Text(
                text = name,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 18.sp,
                fontFamily = SansSerif,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(140.dp))
            Image(
                painter = painterResource(id = com.example.instagramclone.R.drawable.ic_more),
                contentDescription = "More",
                modifier = Modifier.size(20.dp)
            )
        }
        Image(
            painter= rememberImagePainter(data = post),
            contentDescription = "Profile Image",
            modifier= Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(3.dp), alignment = Alignment.Center
        )

        Row(
            modifier = Modifier
                .height(46.dp)
                .fillMaxWidth()
                .padding(start = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = com.example.instagramclone.R.drawable.ic_baseline_favorite_border_24),
                contentDescription = "Favourite",
                modifier = Modifier
                    .size(30.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(40))
            )
            Icon(
                painter = painterResource(id = com.example.instagramclone.R.drawable.comment_icon),
                contentDescription = "Comments",
                modifier = Modifier
                    .size(30.dp)
                    .padding(4.dp)
                    .rotate(280f)
            )
            Icon(
                painter = painterResource(id = com.example.instagramclone.R.drawable.ic_message),
                contentDescription = "Message",
                modifier = Modifier
                    .size(30.dp)
                    .padding(4.dp)
                    .rotate(17.6f)
            )
            Image(
                painter = painterResource(id = com.example.instagramclone.R.drawable.ic_baseline_bookmark_border_24),
                contentDescription = "BookMark",
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
                    .height(28.dp)
                    .clickable {
                       Log.d("bookmark image","bookmark image clicked")
                    },
                alignment = Alignment.CenterEnd
            )
        }

        Text(
            text = "$likeCount likes",
            modifier = Modifier
                .padding(start = 10.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "View all $commentCount comment",
            modifier = Modifier
                .padding(start = 10.dp),
            color = Color.Gray,
            fontSize = 13.sp
        )
        Text(
            text = "$time minutes ago",
            modifier = Modifier
                .padding(start = 10.dp, bottom = 16.dp),
            color = Color.Gray,
            fontSize = 11.sp
        )

        Divider(modifier = Modifier.height(0.6.dp), color = Color(0xFFECECEC))
    }
}