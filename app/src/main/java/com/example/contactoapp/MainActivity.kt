package com.example.contactoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.contactoapp.ui.theme.ContactoappTheme
import com.example.contactoapp.ui.login.LoginScreen
import androidx.navigation.compose.*
import com.example.contactoapp.ui.home.HomeScreen
import com.example.contactoapp.ui.contacts.ContactListScreen
import com.example.contactoapp.ui.contacts.AddContactScreen
import com.example.contactoapp.ui.login.RegisterScreen





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ContactoappTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {

                    composable("login") {
                        LoginScreen(
                            onLoginSuccess = {
                                navController.navigate("home")
                            },
                            onRegisterClick = {
                                navController.navigate("register")
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



                    composable("home") {
                        ContactListScreen(navController)
                    }


                    composable("add_contact") {
                        AddContactScreen {
                            navController.popBackStack()
                        }
                    }
                }

            }
        }
    }
}


