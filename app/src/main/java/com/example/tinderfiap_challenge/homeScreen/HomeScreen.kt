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

data class User(val name: String, val role: String, val description: String, val imageRes: Int)

val userList = listOf(
    User("Sara Adams", "IT Manager", "Gestão de Pessoas - Desenvolvimento Pessoal...", R.drawable.sara),
    User("Camille Johnson", "Software Engineer", "Desenvolvimento de Software - Backend...", R.drawable.user0),
    User("John Doe", "Product Manager", "Gerenciamento de Produtos - Estratégia...", R.drawable.user1),
    User("Jane Smith", "UX Designer", "Design de Experiência do Usuário - Pesquisa...", R.drawable.user2),
    User("Alice Brown", "Data Scientist", "Ciência de Dados - Machine Learning...", R.drawable.user3),
    User("Robert Wilson", "Marketing Specialist", "Marketing Digital - SEO e SEM...", R.drawable.user4),
    User("Emily Davis", "Financial Analyst", "Análise Financeira - Investimentos...", R.drawable.user5),
    User("Michael Johnson", "Sales Manager", "Gerenciamento de Vendas - Estratégias...", R.drawable.user6),
    User("Olivia Martinez", "HR Specialist", "Recursos Humanos - Recrutamento...", R.drawable.user7),
    User("David Lee", "Software Architect", "Arquitetura de Software - Sistemas Distribuídos...", R.drawable.user8),
    User("Emma White", "Operations Manager", "Gerenciamento de Operações - Logística...", R.drawable.user9),
    User("James Harris", "Business Analyst", "Análise de Negócios - Processos...", R.drawable.user10),
    User("Sophia Clark", "Graphic Designer", "Design Gráfico - Branding...", R.drawable.user11),
    User("Benjamin Lewis", "Network Engineer", "Engenharia de Redes - Infraestrutura...", R.drawable.user12),
    User("Amelia Walker", "Public Relations", "Relações Públicas - Comunicação...", R.drawable.user13),
    User("William Hall", "Project Manager", "Gerenciamento de Projetos - Metodologias Ágeis...", R.drawable.user14),
    User("Mia Allen", "Content Writer", "Redação de Conteúdo - Estratégia de Conteúdo...", R.drawable.user15),
    User("Lucas Young", "Cybersecurity Analyst", "Análise de Segurança Cibernética - Proteção de Dados...", R.drawable.user16),
    User("Charlotte King", "Customer Support", "Suporte ao Cliente - Atendimento...", R.drawable.user17),
    User("Elijah Wright", "Machine Learning Engineer", "Engenharia de Machine Learning - IA...", R.drawable.user18)
)

@Composable
fun HomeScreen() {
    var currentUserIndex by remember { mutableStateOf(0) }
    var likeCount by remember { mutableStateOf(0) }
    var showMatch by remember { mutableStateOf(false) }

    val currentUser = userList[currentUserIndex]

    if (showMatch) {
        MatchScreen {
            showMatch = false
            if (currentUserIndex < userList.size - 1) {
                currentUserIndex++
            }
        }
    } else {
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

                ImageSection(currentUser.imageRes)

                Spacer(modifier = Modifier.height(1.dp))

                UserInfoSection(currentUser.name, currentUser.role, currentUser.description)

                Spacer(modifier = Modifier.height(2.dp))

//                ActionButtons()

                Spacer(modifier = Modifier.height(2.dp))

                LikeDislikeButtons(
                    onDislikeClick = {
                        if (currentUserIndex < userList.size - 1) {
                            currentUserIndex++
                        } else {
                            showToast("No more users")
                        }
                    },
                    onInfoClick = { showToast("Info clicked") },
                    onLikeClick = {
                        if (likeCount < 2) {
                            likeCount++
                            if (currentUserIndex < userList.size - 1) {
                                currentUserIndex++
                            }
                        } else {
                            showMatch = true
                            likeCount = 0
                        }
                    }
                )
            }
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
fun ImageSection(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.0f)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun UserInfoSection(name: String, role: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = role,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = description,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

//@Composable
//fun ActionButtons() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Button(
//            onClick = { /* Handle send message action */ },
//            modifier = Modifier
//                .weight(1f)
//                .padding(end = 8.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA726))
//        ) {
//            Text("Send a Message", color = Color.White)
//        }
//        Button(
//            onClick = { /* Handle send action */ },
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 8.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
//        ) {
//            Text("SEND", color = Color.Black)
//        }
//    }
//}

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
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(20.dp) // Set the size for the icon within the IconButton
            )

        }
        IconButton(
            onClick = { onLikeClick() },
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
        ) {
            Icon(painter = painterResource(id = R.mipmap.ic_launcher_foreground), contentDescription = null, tint = Color.Green)
        }
    }
}

@Composable
fun MatchScreen(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222E36).copy(alpha = 0.8f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(32.dp)
        ) {
            Text(
                text = "It's a Match!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Envie uma mensagem para saber mais sobre o usuário",
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(0.4f)
                ) {
                    Text(text = "Envie uma mensagem")

                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = onDismiss) {
                    Text(text = "Não Agora...")
                }
            }
        }
    }
}

fun showToast(message: String) {
    // Implemente o código para mostrar um toast com a mensagem fornecida.
    // Por exemplo, se estiver usando uma Activity, você pode usar:
    // Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
