package com.example.tinderfiap_challenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tinderfiap_challenge.login.LoginScreen
import com.example.tinderfiap_challenge.loginEmail.LoginEmail
import com.example.tinderfiap_challenge.cadastro.SignUpScreen
import com.example.tinderfiap_challenge.uploadImg.UploadImgScreen
import com.example.tinderfiap_challenge.homeScreen.HomeScreen
import com.example.tinderfiap_challenge.learningSkills.LearningSkillsScreen
import com.example.tinderfiap_challenge.loginEmail.emailHome
import com.example.tinderfiap_challenge.skillScreen.SkillScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "loginScreen") {

        composable("loginScreen") {
            LoginScreen(
                onNavigateToLogin = {navController.navigate("loginEmail") },
                onNavigateToSignUp = {navController.navigate("signUpScreen") },
            )
        }

        composable("loginEmail") {
            LoginEmail(
                onHomeScreen = {navController.navigate("homeScreen") }
            )
        }

        composable("signUpScreen") {
            SignUpScreen(
                onNavigateSignUpDone = {navController.navigate("skillScreen") }
            )
        }
        composable("skillScreen") {
            SkillScreen(
                onSkillScreenDone = {navController.navigate("learningSkillsScreen") }
            )
        }

        composable("learningSkillsScreen") {
            LearningSkillsScreen(
                onLearningSkillsScreenDone = {navController.navigate("uploadImgScreen") }
            )
        }

        composable("uploadImgScreen") {
            UploadImgScreen(
                onPhotoUpload = {},
                onFisnish = {navController.navigate("homeScreen") }
            )
        }

        composable("homeScreen") {
            HomeScreen(
                emailHome
            )
        }
    }
}
