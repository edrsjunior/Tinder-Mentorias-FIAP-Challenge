package com.example.tinderfiap_challenge.learningSkills

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tinderfiap_challenge.R

@Composable
fun LearningSkillsScreen(onLearningSkillsScreenDone: () -> Unit) {
    val skills = listOf(
        "REACT", "HTTP", "GESTAO DE PESSOAS", "CONTROLE DE PROCESSOS", "ANALTICS",
        "POWER BI", "AUTOMACAO", "WEB", "APIs Rest", "FIGMA", "AUTOMACAO", "WEB", "APIs Rest", "FIGMA"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222E36))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBarLearningSkillsScreen()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Habilidades que você busca aprender...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            skills.chunked(2).forEach { rowSkills ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowSkills.forEach { skill ->
                        SkillButton(skill)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = { onLearningSkillsScreenDone() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Continuar", color = Color.Black)
            }

        }

        Spacer(modifier = Modifier.height(24.dp))


    }
}

@Composable
fun TopBarLearningSkillsScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Handle back action */ }) {
            Icon(
                //ic_arrow_back
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Color.White
            )
        }
        IconButton(onClick = { /* Handle menu action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Color.White
            )
        }
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
