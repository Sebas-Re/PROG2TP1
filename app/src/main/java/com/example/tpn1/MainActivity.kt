package com.example.tpn1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            @Composable
            fun MyScreen() {
                Scaffold(
                    topBar = {
                        SimpleHeader()
                    }
                ) { padding -> //Use the padding provided by Scaffold
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = { /* Handle first button click */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite"
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // Add some space between buttons
                        IconButton(onClick = { /* Handle second buttonclick */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleHeader() {
    TopAppBar(
        title = { Text("TP Nº1") },
        colors = topAppBarColors(containerColor = Color.Cyan)

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyScreenPreview() {
    Scaffold(topBar = {SimpleHeader() }) { padding ->
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Column {
                        Button(onClick = { /* Handle button click */ }) {
                            Text("Ejercicio 1")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { /* Handle button click */ }) {
                            Text("Ejercicio 2")
                        }
                    }
                }
            }
            Text(
                text = "INTEGRANTES: Sebastián Re, Cristian Benitez, Manuel Pais, Adriel Lopez, Dario Troilo",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp))
        }
    }
}
