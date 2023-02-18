package com.example.servicesvk

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun ServiceScreen(
    navController: NavController,
    name: String,
    description: String,
    iconUrl: String,
    serviceUrl: String
) {
    val context = LocalContext.current
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(serviceUrl))

    Column() {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xff0077ff))
        ) {
            Row() {
                IconButton(
                    onClick = { navController.navigate("main") }
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

        }

        //Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            AsyncImage(model = iconUrl, contentDescription = null)
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = description)
            TextButton(onClick = { context.startActivity(webIntent) }) {
                Text(text = serviceUrl)
            }
        }
    }
}