package com.example.servicesvk

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    var refreshCount by remember { mutableStateOf(1) }

    val services by remember { mainViewModel.servicesData }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(15.dp)
    ) {
        items(services.items) { service ->
            ServiceRow(service)
        }
    }

    LaunchedEffect(key1 = refreshCount) {
        mainViewModel.getServices()
    }
}

@Composable
fun ServiceRow(service: Service) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.clickable(onClick = {})
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
