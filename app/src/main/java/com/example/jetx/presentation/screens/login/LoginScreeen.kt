package com.example.jetx.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val LoginVector: ImageVector by lazy {
    ImageVector.Builder(
        name = "Login",
        defaultWidth = 402.dp,
        defaultHeight = 874.dp,
        viewportWidth = 402f,
        viewportHeight = 874f
    ).apply {
        addPath(
            pathData = PathParser().parsePathString("M0 0H402V874H0Z").toNodes(),
            fill = SolidColor(Color(0xFF050505))
        )
        addPath(
            pathData = PathParser().parsePathString("M39 219H362C378.56854 219 392 232.43146 392 249V610C392 626.56854 378.56854 640 362 640H39C22.43146 640 9 626.56854 9 610V249C9 232.43146 22.43146 219 39 219Z").toNodes(),
            fill = SolidColor(Color(0xFF070B14)),
            fillAlpha = 0.69f
        )
        addPath(
            pathData = PathParser().parsePathString("M87.5 260H313.5C323.71727 260 332 268.28273 332 278.5V278.5C332 288.71727 323.71727 297 313.5 297H87.5C77.28273 297 69 288.71727 69 278.5V278.5C69 268.28273 77.28273 260 87.5 260Z").toNodes(),
            fill = SolidColor(Color(0xFFD9D9D9)),
            fillAlpha = 0.43f
        )
        addPath(
            pathData = PathParser().parsePathString("M87.5 332H313.5C323.71727 332 332 340.28273 332 350.5V350.5C332 360.71727 323.71727 369 313.5 369H87.5C77.28273 369 69 360.71727 69 350.5V350.5C69 340.28273 77.28273 332 87.5 332Z").toNodes(),
            fill = SolidColor(Color(0xFFD9D9D9)),
            fillAlpha = 0.44f
        )
        addPath(
            pathData = PathParser().parsePathString("M168.976 78.352C168.976 81.104 168.187 83.1307 166.608 84.432 165.051 85.7333 162.8 86.384 159.856 86.384 156.912 86.384 154.651 85.7333 153.072 84.432 151.515 83.1307 150.736 81.104 150.736 78.352V78.064H157.36V78.32C157.36 79.3227 157.541 80.0373 157.904 80.464 158.288 80.8907 158.864 81.104 159.632 81.104 160.4 81.104 160.965 80.8907 161.328 80.464 161.712 80.0373 161.904 79.3227 161.904 78.32V63.984H168.976V78.352ZM181.156 68.72C184.249 68.72 186.607 69.4453 188.228 70.896 189.871 72.3467 190.692 74.5653 190.692 77.552V78.64H178.02C178.02 79.856 178.287 80.7733 178.82 81.392 179.375 82.0107 180.239 82.32 181.412 82.32 182.479 82.32 183.257 82.096 183.748 81.648 184.26 81.2 184.516 80.6027 184.516 79.856H190.692C190.692 81.904 189.913 83.504 188.356 84.656 186.799 85.808 184.527 86.384 181.54 86.384 178.404 86.384 175.972 85.6587 174.244 84.208 172.516 82.736 171.652 80.5173 171.652 77.552 171.652 74.6507 172.495 72.4533 174.18 70.96 175.865 69.4667 178.191 68.72 181.156 68.72ZM181.412 72.784C179.407 72.784 178.287 73.7333 178.052 75.632H184.26C184.26 74.7573 184.004 74.064 183.492 73.552 183.001 73.04 182.308 72.784 181.412 72.784ZM205.028 69.104V73.424H201.444V79.856C201.444 80.624 201.572 81.1893 201.828 81.552 202.084 81.8933 202.553 82.064 203.236 82.064H205.028V85.808C204.516 85.9787 203.854 86.1173 203.044 86.224 202.233 86.3307 201.529 86.384 200.932 86.384 199.054 86.384 197.604 86.0427 196.58 85.36 195.577 84.6773 195.076 83.5147 195.076 81.872V73.424H192.708V69.104H195.332L196.708 63.984H201.444V69.104H205.028ZM241.615 86H233.039L228.975 79.152H228.847L224.783 86H216.847L224.719 74.352 217.615 63.984H226.159L229.487 69.616H229.615L232.975 63.984H240.879L233.743 74.384 241.615 86Z").toNodes(),
            fill = SolidColor(Color(0xFFFFFFFF))
        )
    }.build()
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {}
) {
    Image(
        imageVector = LoginVector,
        contentDescription = "Pantalla de Login",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}