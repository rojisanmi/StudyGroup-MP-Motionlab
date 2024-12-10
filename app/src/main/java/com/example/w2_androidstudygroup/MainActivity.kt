package com.example.w2_androidstudygroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.w2_androidstudygroup.ui.theme.W2_AndroidStudyGroupTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            W2_AndroidStudyGroupTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = LoginScreen) {
                    composable<LoginScreen> {
                        LoginScreen(navController)
                    }
                    composable<HomeScreen> {
                        HomeScreen(navController)
                    }
                    composable<RegisterScreen> {
                        RegisterScreen(navController)
                    }
                    composable<MemberDetail> {
                        val args = it.toRoute<MemberDetail>()
                        MemberDetailScreen(args)
                    }
                }

            }
        }
    }
}

@Serializable
object LoginScreen

@Serializable
object HomeScreen

@Serializable
object RegisterScreen

@Serializable
data class MemberDetail(val memberName : String, val memberRole : String, val memberImageUrl : String)