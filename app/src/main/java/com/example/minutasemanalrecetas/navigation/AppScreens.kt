package com.example.minutasemanalrecetas.navigation

sealed class AppScreens(val route: String) {
    object Login : AppScreens("login")
    object Register : AppScreens("register")
    object RecoverPassword : AppScreens("recover_password")
    object Minuta : AppScreens("minuta")
}
