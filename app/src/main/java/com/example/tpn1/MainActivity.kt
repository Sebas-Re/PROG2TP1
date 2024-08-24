package com.example.tpn1

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.text.Editable
import android.text.TextWatcher
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiApp()
        }
    }
}

@Composable
fun MiApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "PantallaPrincipal") {
        composable("PantallaPrincipal") { PantallaPrincipal(navController) }
        composable("PantallaEjercicio1") { PantallaEjercicio1() }
        composable("PantallaEjercicio2") { PantallaEjercicio2() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal_Header() {
    TopAppBar(
        title = { Text("TP Nº1") },
        colors = topAppBarColors(containerColor = Color.Blue)

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEjercicio1Header() {
    TopAppBar(
        title = {
            Text(
                text = "Suma",
                color = Color.White,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        },
        colors = topAppBarColors(containerColor = Color.Blue)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEjercicio2Header() {
    TopAppBar(
        title = {
            Text(
                text = "Calculadora",
                color = Color.White,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        },
        colors = topAppBarColors(containerColor = Color.Blue)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPrincipalPreview() {
    val navController = rememberNavController() // NavController ficticio
    PantallaPrincipal(navController)
}


@Suppress("PreviewAnnotationInFunctionWithParameters")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPrincipal(navController: NavController) {
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
                        Button(onClick = {navController.navigate("PantallaEjercicio1")}) {
                            Text("Ejercicio 1")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {navController.navigate("PantallaEjercicio2")}) {
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
fun PantallaEjercicio1() {
    var primerNumero by remember { mutableStateOf("") }
    var segundoNumero by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf<Int?>(null) }

    Scaffold(topBar = { PantallaEjercicio1Header() }) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(top = 40.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,  // Alinear verticalmente al centro
                //horizontalArrangement = Arrangement.Start,       // Alinear horizontalmente al inicio
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                // TextView
                AndroidView(
                    factory = { context ->
                        TextView(context).apply {
                            text = "Primer Número:"  // Establece el texto
                            textSize = 20f  // Establece el tamaño del texto
                        }
                    },
                    modifier = Modifier
                        //.weight(1f)
                        .padding(top = 4.dp)
                )

                // EditText (solo números)
                AndroidView(
                    factory = { context ->
                        EditText(context).apply {
                            //hint = "Número"
                            inputType = android.text.InputType.TYPE_CLASS_NUMBER  // Solo números
                            textSize = 20f
                            setText(primerNumero)  // Configura el texto inicial
                            addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                                    primerNumero = s.toString()
                                }
                                override fun afterTextChanged(s: Editable?) {}
                            })
                        }
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .padding(20.dp)
                )
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,  // Alinear verticalmente al centro
                //horizontalArrangement = Arrangement.Start,       // Alinear horizontalmente al inicio
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                // TextView
                AndroidView(
                    factory = { context ->
                        TextView(context).apply {
                            text = "Segundo Número:"  // Establece el texto
                            textSize = 20f  // Establece el tamaño del texto
                        }
                    },
                    modifier = Modifier
                        //.weight(1f)
                        .padding(top = 4.dp)
                )

                // EditText (solo números)
                AndroidView(
                    factory = { context ->
                        EditText(context).apply {
                            //hint = "Número"
                            inputType = android.text.InputType.TYPE_CLASS_NUMBER  // Solo números
                            textSize = 20f
                            setText(segundoNumero)  // Configura el texto inicial
                            addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                                    segundoNumero = s.toString()
                                }
                                override fun afterTextChanged(s: Editable?) {}
                            })
                        }
                    },
                    modifier = Modifier.width(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Button(
                onClick = {
                    val num1 = primerNumero.toIntOrNull()
                    val num2 = segundoNumero.toIntOrNull()
                    if (num1 != null && num2 != null) {
                        resultado = num1 + num2
                    } else {
                        resultado = null // Maneja el caso de valores no numéricos
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally) // centrar botón
            ) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(19.dp))

            resultado?.let {
                Text(
                    text = "Resultado: $it",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.Black,
                    fontSize = 19.sp
                )
            }


            Spacer(modifier = Modifier.weight(1f))

        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaEjercicio2() {
    var primerNumero by remember { mutableStateOf("") }
    var segundoNumero by remember { mutableStateOf("") }
    var operacion by remember { mutableStateOf<String?>(null) }
    var resultado by remember { mutableStateOf<Int?>(null) }
    var expression by remember { mutableStateOf("0") }
    var isResultDisplayed by remember { mutableStateOf(false) }  // Bandera para saber si se mostró el resultado

    Scaffold(topBar = { PantallaEjercicio2Header() }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            var editText: EditText? = null

            // EditText para mostrar la expresión y el resultado
            AndroidView(
                factory = { context ->
                    EditText(context).apply {
                        inputType = android.text.InputType.TYPE_CLASS_TEXT  // Permitir números y texto
                        textSize = 20f
                        setText(expression)  // Configura el texto inicial
                        editText = this  // Asigna la referencia al EditText
                    }
                },
                modifier = Modifier.width(500.dp)
            )

            Row {
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "7"
                            segundoNumero = ""
                            expression = "7"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "7"
                            expression = if (expression == "0") "7" else expression + "7"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("7")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "8"
                            segundoNumero = ""
                            expression = "8"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "8"
                            expression = if (expression == "0") "8" else expression + "8"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("8")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "9"
                            segundoNumero = ""
                            expression = "9"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "9"
                            expression = if (expression == "0") "9" else expression + "9"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("9")
                }
                Button(
                    onClick = {
                        primerNumero = resultado?.toString() ?: segundoNumero
                        segundoNumero = ""
                        operacion = "+"
                        expression += "+"
                        isResultDisplayed = false
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+")
                }
            }
            Row {
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "4"
                            segundoNumero = ""
                            expression = "4"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "4"
                            expression = if (expression == "0") "4" else expression + "4"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("4")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "5"
                            segundoNumero = ""
                            expression = "5"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "5"
                            expression = if (expression == "0") "5" else expression + "5"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("5")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "6"
                            segundoNumero = ""
                            expression = "6"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "6"
                            expression = if (expression == "0") "6" else expression + "6"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("6")
                }
                Button(
                    onClick = {
                        primerNumero = resultado?.toString() ?: segundoNumero
                        segundoNumero = ""
                        operacion = "-"
                        expression += "-"
                        isResultDisplayed = false
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("-")
                }
            }
            Row {
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "1"
                            segundoNumero = ""
                            expression = "1"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "1"
                            expression = if (expression == "0") "1" else expression + "1"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("1")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "2"
                            segundoNumero = ""
                            expression = "2"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "2"
                            expression = if (expression == "0") "2" else expression + "2"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("2")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "3"
                            segundoNumero = ""
                            expression = "3"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "3"
                            expression = if (expression == "0") "3" else expression + "3"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("3")
                }
                Button(
                    onClick = {
                        primerNumero = resultado?.toString() ?: segundoNumero
                        segundoNumero = ""
                        operacion = "*"
                        expression += "*"
                        isResultDisplayed = false
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("*")
                }
            }
            Row {
                Button(
                    onClick = {
                        primerNumero = ""
                        segundoNumero = ""
                        resultado = null
                        operacion = null
                        expression = "0"
                        isResultDisplayed = false
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("BORRAR")
                }
                Button(
                    onClick = {
                        if (isResultDisplayed) {
                            primerNumero = "0"
                            segundoNumero = ""
                            expression = "0"
                            isResultDisplayed = false
                        } else {
                            segundoNumero += "0"
                            expression = if (expression == "0") "0" else expression + "0"
                        }
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("0")
                }
                Button(
                    onClick = {
                        when (operacion) {
                            "+" -> resultado = primerNumero.toInt() + segundoNumero.toInt()
                            "-" -> resultado = primerNumero.toInt() - segundoNumero.toInt()
                            "*" -> resultado = primerNumero.toInt() * segundoNumero.toInt()
                            "/" -> resultado = primerNumero.toInt() / segundoNumero.toInt()
                        }
                        expression = resultado.toString()
                        editText?.setText(expression)
                        primerNumero = resultado.toString()  // Guardar el resultado en primerNumero
                        segundoNumero = ""
                        operacion = null
                        isResultDisplayed = true  // Marcar que se mostró el resultado
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("=")
                }
                Button(
                    onClick = {
                        primerNumero = resultado?.toString() ?: segundoNumero
                        segundoNumero = ""
                        operacion = "/"
                        expression += "/"
                        isResultDisplayed = false
                        editText?.setText(expression)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("/")
                }
            }
        }
    }
}




