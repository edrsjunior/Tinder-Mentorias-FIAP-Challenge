package com.example.tinderfiap_challenge.skillScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import com.example.tinderfiap_challenge.R

@Composable
fun SkillScreen(onSkillScreenDone: () -> Unit) {
    var jobTitle by remember { mutableStateOf(TextFieldValue("Engenheiro de Software")) }
    val skills = listOf(
        "REACT", "HTTP", "GESTAO DE PESSOAS", "CONTROLE DE PROCESSOS", "ANALTICS",
        "POWER BI", "AUTOMACAO", "WEB", "APIs Rest", "FIGMA"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222E36))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBarSkillScreen()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Vamos conhecer você um pouco mais...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Seu cargo atual",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        BasicTextField(
            value = jobTitle,
            onValueChange = { jobTitle = it },
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(vertical = 8.dp)
        )
        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Algumas de suas habilidades...",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            skills.forEach { skill ->
                SkillButton(skill)
                Spacer(modifier = Modifier.height(8.dp))
            }
            Button(
                onClick = { onSkillScreenDone() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Continuar", color = Color.Black)
            }
        }
    }
}

@Composable
fun TopBarSkillScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
    }
}

@Composable
fun SkillButton(skill: String) {
    Button(
        onClick = { /* Handle skill click */ },
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(skill, color = Color.White)
    }
}
