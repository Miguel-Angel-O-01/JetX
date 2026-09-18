package com.example.jetx.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jet X Executive",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Ingrese sus credenciales para continuar"
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                mensaje = ""
                },
            label = { Text("Usuario")  },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contraseña,
            onValueChange = {
                contraseña = it
                mensaje = ""
                },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (contraseña.isEmpty()) {
            Text(
                text = "Ingrese su contraseña",
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(
            text = "Caracteres: ${contraseña.length}",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    mensaje = "Complete todos los campos"
                } else if (usuario.length < 3) {
                    mensaje = "El usuario debe tener al menos 3 caracteres"
                } else if (contraseña.length < 6) {
                    mensaje = "La contraseña debe tener al menos 6 caracteres"
                } else {
                    onLoginSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar Sesión")
        }

        if (mensaje.isNotEmpty()) {
            Text(
                text = mensaje,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Continuar con Google")
        }
    }
}