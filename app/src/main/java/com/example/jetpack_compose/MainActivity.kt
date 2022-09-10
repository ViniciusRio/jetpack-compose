package com.example.jetpack_compose

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                Surface() {
                    ComposeCenterCard()
                }
            }
        }
    }
}


@Composable
fun ComposeCenterCard() {
    CenterCard(
        fullName = "Jennifer Doe",
        title = "Android Developer Extraordinaire",
        imagePainter = painterResource(id = R.drawable.android_logo)
    )
    ContactCard(
        contactNumber = "+11 (123) 444 555 666",
        instagram = "@AndroidDev",
        email = "jen.doe@android.com"
    )

}

@Composable
fun CenterCard(
    fullName: String,
    title: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(
                    rgb(13, 58, 74)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = modifier.size(120.dp)
        )
        Text(
            text = fullName,
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight(300)

        )

        Spacer(modifier = modifier.height(8.dp))

        Text(
            text = title,
            color = Color(rgb(109, 221, 154)),
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        )

    }
}


@Composable
fun ContactCard(
    contactNumber: String,
    instagram: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(color = Color.White, thickness = 0.5.dp)

        Row(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(90.dp))

            Icon(
                Icons.Filled.Phone,
                contentDescription = null,
                tint = Color(rgb(109, 221, 154))

            )

            Spacer(modifier = modifier.width(20.dp))

            Text(
                text = contactNumber,
                color = Color.White,
                fontWeight = FontWeight(400)

            )

        }

        Divider(color = Color.White, thickness = 0.5.dp)

        Row(
            modifier = modifier
                .padding(bottom = 8.dp, top = 8.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(90.dp))

            Icon(
                Icons.Filled.Share,
                contentDescription = null,
                tint = Color(rgb(109, 221, 154))
            )

            Spacer(modifier = modifier.width(20.dp))

            Text(
                text = instagram,
                color = Color.White,
                fontWeight = FontWeight(400)
            )

        }

        Divider(color = Color.White, thickness = 0.5.dp)

        Row(

            modifier = modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = modifier.width(90.dp))

            Icon(
                Icons.Filled.Email,
                contentDescription = null,
                tint = Color(rgb(109, 221, 154)),
            )

            Spacer(modifier = modifier.width(20.dp))

            Text(
                text = email,
                color = Color.White,
                fontWeight = FontWeight(400),
            )


        }
        Spacer(modifier = modifier.height(40.dp))

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackcomposeTheme {
        Surface()
        {
            ComposeCenterCard()
        }
    }
}