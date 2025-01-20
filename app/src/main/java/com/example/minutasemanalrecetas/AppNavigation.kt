package com.example.minutasemanalrecetas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minutasemanalrecetas.screens.LoginScreen
import com.example.minutasemanalrecetas.screens.MinutaScreen
import com.example.minutasemanalrecetas.screens.RecoverPasswordScreen
import com.example.minutasemanalrecetas.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                onNavigateToRecover = {
                    navController.navigate("recover_password")
                },
                onLoginSuccess = {
                    navController.navigate("minuta")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.popBackStack()
                }
            )
        }

        composable("recover_password") {
            RecoverPasswordScreen(
                onRecoverySuccess = {
                    navController.popBackStack()
                }
            )
        }

        composable("minuta") {
            MinutaScreen()
        }
    }
}