package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ComposeTaskManager()
                }
            }
        }
    }
}
@Composable
fun ComposeTaskManager() {
    TaskManager(
        statusMessage = stringResource(R.string.statusMessage),
        customMessage = stringResource(R.string.customMessage),
        painterImage = painterResource(id = R.drawable.ic_task_completed),
    )
}

@Composable
private fun TaskManager(
    statusMessage: String,
    customMessage: String,
    painterImage: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterImage,
            contentDescription = null
        )
        Text(
            text = statusMessage,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = customMessage,
            fontSize = 16.sp,
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackcomposeTheme {
        ComposeTaskManager()
    }
}