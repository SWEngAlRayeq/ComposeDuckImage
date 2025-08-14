package app.duck_image.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.duck_image.presentation.viewmodel.DuckViewModel
import coil.compose.AsyncImage

@Composable
fun DuckScreen(viewmodel: DuckViewModel = hiltViewModel()) {

    val duck by viewmodel.duck.collectAsState()

    LaunchedEffect(Unit) {
        viewmodel.loadRandomDuck()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(Color(0xFFFFD54F), Color(0xFFFFB300)))
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "❤ Duck Generator",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            )

            Spacer(Modifier.height(24.dp))

            if (duck != null) {
                AsyncImage(
                    model = duck!!.imageUrl,
                    contentDescription = "Duck Image",
                    modifier = Modifier
                        .size(280.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                CircularProgressIndicator(color = Color.White)
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { viewmodel.loadRandomDuck() },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFB8C00)),
                modifier = Modifier.size(70.dp)
            ) {
                Text("🦆", style = MaterialTheme.typography.headlineSmall)
            }

        }
    }


}
