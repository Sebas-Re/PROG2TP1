package com.example.tpn1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            PantallaPrincipalPreview()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal_Header() {
    TopAppBar(
        title = { Text("TP Nº1") },
        colors = topAppBarColors(containerColor = Color.Cyan)

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEjercicio1Header() {
    TopAppBar(
        title = { Text("Ejercicio 1") },
        colors = topAppBarColors(containerColor = Color.Cyan)

    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPrincipalPreview() {
    Scaffold(topBar = {PantallaPrincipal_Header() }) { padding ->
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaEjercicio1Preview() {
    Scaffold(topBar = { PantallaEjercicio1Header() }) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround  // distribuye los elementos uniformemente
            ) {
                TextFieldNumeros(texto = "Primer Numero")
                TextFieldNumeros(texto = "Segundo Numero")
            }

            Spacer(modifier = Modifier.height(19.dp))

            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier.align(Alignment.CenterHorizontally) // centrar boton
            ) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "INTEGRANTES: Sebastián Re, Cristian Benitez, Manuel Pais, Adriel Lopez, Dario Troilo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun TextFieldNumeros(texto: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(texto) }
    )
}
