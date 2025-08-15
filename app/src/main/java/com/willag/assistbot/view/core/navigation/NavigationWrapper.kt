package com.willag.assistbot.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.willag.assistbot.view.auth.login.LoginScreen
import com.willag.assistbot.view.auth.register.RegisterScreen
import com.willag.assistbot.view.onboarding.OnBoardingScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(onNavigateToRegister = {
                navController.navigate(Register)
            })
        }
        composable<Register> {
            RegisterScreen(
                onNavigateToOnboarding = {
                    navController.navigate(Onboarding) {
                        popUpTo(Onboarding) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                navController.navigate(Login) {
                    popUpTo(Login) { inclusive = true }
                }
            })
        }

        composable<Onboarding> {
            OnBoardingScreen()
        }
    }
}