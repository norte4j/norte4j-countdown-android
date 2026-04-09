package br.com.psdit.countdown

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.psdit.countdown.ui.theme.CountDownTheme
import br.com.psdit.countdown.ui.theme.Purple80

fun formatTime(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
fun CountdownScreen(viewModel: CountdownViewModel = viewModel()) {

    val timeLeft by viewModel.timeLeft.collectAsState()

    LaunchedEffect(Unit) {
//        viewModel.startCountdown()
    }

    val formattedTime = formatTime(timeLeft)

    Scaffold(
        topBar = {
            Text(
                text = "Norte4j - Countdown",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple80)
                    .padding(16.dp),
                color = Color.White
            )
        }
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .background(Purple80),
            contentAlignment = Alignment.Center
        ) {
            DigitalTimer(text = formattedTime)

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement
                    .spacedBy(10.dp, Alignment.CenterHorizontally)
                ,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = { viewModel.reset() },
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                ) {
                    Text("Reset")
                }

                Button(
                    onClick = { viewModel.pause() },
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    Text("Pause")
                }

                Button(
                    onClick = { viewModel.resume() },
                    modifier = Modifier.padding(bottom = 32.dp)
                ) {
                    Text("Continue")
                }
            }
        }
    }


}

@PreviewScreenSizes
@Composable
fun CountdownScreenPreview() {
    CountDownTheme {
        CountdownScreen()
    }
}