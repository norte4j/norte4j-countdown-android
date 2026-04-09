package br.com.psdit.countdown

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import br.com.psdit.countdown.ui.theme.CountDownTheme

val digitalFont = FontFamily(
    Font(R.font.digital_7)
)

@Composable
fun DigitalTimer(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 50.em,
        fontFamily = digitalFont, // estilo digital
        letterSpacing = 4.sp
    )
}

@PreviewLightDark
@Composable
fun DigitalTimerPreview() {
    CountDownTheme {
        DigitalTimer("00:45:00")
    }
}