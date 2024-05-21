package com.example.tinderfiap_challenge.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinderfiap_challenge.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222E36))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TopBar()

        Spacer(modifier = Modifier.height(1.dp))

            ImageSection()

        Spacer(modifier = Modifier.height(2.dp))

            UserInfoSection()

        Spacer(modifier = Modifier.height(2.dp))

            ActionButtons()

        Spacer(modifier = Modifier.height(2.dp))

            LikeDislikeButtons(
                onDislikeClick = { showToast("Dislike clicked") },
                onInfoClick = { showToast("Info clicked") },
                onLikeClick = { showToast("Like clicked") }
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

        TextFieldIcon(placeholherText = "Search")

        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun TextFieldIcon(placeholherText: String){
    var textSender by remember { mutableStateOf("") }
    TextField(
        value = textSender,
        placeholder = { Text(text = placeholherText, color = Color.Gray, fontSize = 12.sp)},
        onValueChange = { textSender = it },

        shape = RoundedCornerShape(40.dp), // Add border radius
        textStyle = LocalTextStyle.current.copy(color = Color.Black)
    )

}

@Composable
fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.sara),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.0f)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun UserInfoSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Sara Adams",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "IT Manager",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Gestão de Pessoas - Desenvolvimento Pessoal...",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /* Handle send message action */ },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726))
        ) {
            Text("Send a Message", color = Color.White)
        }
        Button(
            onClick = { /* Handle send action */ },
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("SEND", color = Color.Black)
        }
    }
}

@Composable
fun LikeDislikeButtons(
    onDislikeClick: () -> Unit,
    onInfoClick: () -> Unit,
    onLikeClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onDislikeClick() },
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
        ) {
            //ic_close
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null, tint = Color.Red)
        }
        IconButton(
            onClick = { onInfoClick() },
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
        ) {
            //ic_info
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null, tint = Color.Gray)
        }
        IconButton(
            onClick = { onLikeClick() },
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
        ) {
            //ic_heart
            Icon(painter = painterResource(id = R.mipmap.ic_launcher_foreground), contentDescription = null, tint = Color.Green)
        }
    }
}

fun showToast(message: String) {
    // Implemente o código para mostrar um toast com a mensagem fornecida.
    // Por exemplo, se estiver usando uma Activity, você pode usar:
    // Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
