package com.example.jetx.presentation.screen.login

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetx.R

val ArchivoBlack = FontFamily(Font(R.font.archivoblackregular))

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    viewModel: LoginViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF050505))
    ) {
        // Fondo con el avión
        Image(
            painter = painterResource(id = R.drawable.loginimage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.80f)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
            contentScale = ContentScale.Crop
        )

        // Contenido interactivo
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login_title),
                color = Color.White,
                fontSize = 36.sp,
                fontFamily = ArchivoBlack,
                modifier = Modifier.padding(top = 64.dp, bottom = 32.dp)
            )

            // Tarjeta translúcida estilo Figma
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color(0xFF070B14).copy(alpha = 0.69f))
                    .padding(start = 24.dp, end = 24.dp, top = 32.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = uiState.username,
                        onValueChange = { viewModel.onUsernameChanged(it) },
                        placeholder = { Text(stringResource(id = R.string.hint_username)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(27.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedContainerColor = Color.White.copy(alpha = 0.15f),
                            unfocusedContainerColor = Color.White.copy(alpha = 0.1f),
                            focusedPlaceholderColor = Color.White.copy(alpha = 0.6f),
                            unfocusedPlaceholderColor = Color.White.copy(alpha = 0.6f),
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = uiState.password,
                        onValueChange = { viewModel.onPasswordChanged(it) },
                        placeholder = { Text(stringResource(id = R.string.hint_password)) },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(27.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                                viewModel.login(onLoginSuccess)
                            }
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedContainerColor = Color.White.copy(alpha = 0.15f),
                            unfocusedContainerColor = Color.White.copy(alpha = 0.1f),
                            focusedPlaceholderColor = Color.White.copy(alpha = 0.6f),
                            unfocusedPlaceholderColor = Color.White.copy(alpha = 0.6f),
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .clickable { /* Acción de recuperación */ }
                    )

                    uiState.errorMessage?.let { error ->
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = error,
                            color = Color(0xFFFF5252),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { viewModel.login(onLoginSuccess) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(27.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.1f)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.btn_login),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = stringResource(id = R.string.new_client),
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable { /* Acción de registro */ }
                    )
                }
            }
        }

        // Pantalla de carga animada
        if (uiState.isLoading) {
            val infiniteTransition = rememberInfiniteTransition(label = "Carga Avion")
            val alphaAnimation by infiniteTransition.animateFloat(
                initialValue = 0.2f,
                targetValue = 1.0f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 800, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "Opacidad Avion"
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.75f))
                    .clickable(enabled = false) { },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.loadingimage), // O usa R.drawable.logo_login_page_2 según cuál quieras
                        contentDescription = "Logo de Inicio",
                        modifier = Modifier.size(80.dp) // Puedes ajustar el tamaño que desees aquí
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Conectando...",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}