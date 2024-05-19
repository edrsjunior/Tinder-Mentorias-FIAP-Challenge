package com.example.tinderfiap_challenge.uploadImg

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinderfiap_challenge.R

@Composable
fun UploadImgScreen(onPhotoUpload: () -> Unit, onFisnish: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222E36))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Para finalizar vamos enviar uma foto...",
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        val painter: Painter = painterResource(id = R.drawable.profile_send)

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color(0xFF36454F), shape = CircleShape)
                .clickable { onPhotoUpload() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = "Upload Photo Icon",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = { onFisnish() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Finalizar", color = Color.Black)
        }
    }
}