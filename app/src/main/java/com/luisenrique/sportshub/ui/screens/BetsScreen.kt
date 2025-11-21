import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luisenrique.sportshub.R

@Composable
fun BetsScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Haz tu apuesta", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Elige un equipo:")
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudo_ies_chabas),
                contentDescription = "IES Chabas",
                modifier = Modifier.size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = { /* no funcional */ }) {
                Text("IES Chabas", fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.width(4.dp))

            Image(
                painter = painterResource(id = R.drawable.escudo_maria_ivars),
                contentDescription = "IES Chabas",
                modifier = Modifier.size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(4.dp))

            Button(onClick = { /* no funcional */ }) {
                Text("IES Maria Ibars", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Número de apuesta (€)") },
            enabled = true
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = { /* no funcional */ }) {
            Text("Hacer apuesta")
        }
    }
}
