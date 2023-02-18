package com.example.servicesvk

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.servicesvk.dto.Service
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun MainScreen(mainViewModel: MainViewModel, navController: NavHostController) {
    var refreshCount by remember { mutableStateOf(1) }

    val services by remember { mainViewModel.servicesData }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xff0077ff))
    ) {
        Text(
            text = stringResource(R.string.services),
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 20.dp, start = 10.dp)
        )
    }

    Spacer(modifier = Modifier.height(50.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(top = 100.dp, start = 15.dp)
    ) {
        items(services.items) { service ->
            ServiceRow(service, navController)
        }
    }

    LaunchedEffect(key1 = refreshCount) {
        mainViewModel.getServices()
    }
}

@Composable
fun ServiceRow(service: Service, navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                navController.navigate(
                    "service" + "/" + service.name +
                            "/" + service.description +
                            "/" + URLEncoder.encode(
                        service.icon_url,
                        StandardCharsets.UTF_8.toString()
                    ) + "/" + URLEncoder.encode(
                        service.service_url,
                        StandardCharsets.UTF_8.toString()
                    )
                )
            }
            )
    ) {
        AsyncImage(
            model = service.icon_url,
            contentDescription = null,
            modifier = Modifier.size(44.dp)
        )
        //Spacer(modifier = Modifier.weight(1f))
        Text(text = service.name)
    }
}
