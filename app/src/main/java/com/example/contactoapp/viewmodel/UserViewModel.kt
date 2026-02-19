package com.example.contactoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactoapp.data.User
import com.example.contactoapp.database.AppDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()

    fun register(
        username: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {

            val existingUser = userDao.getUser(username)

            if (existingUser != null) {
                onResult(false, "El usuario ya existe")
            } else {
                userDao.insert(User(username, password))
                onResult(true, "Usuario registrado correctamente")
            }
        }
    }

    fun login(
        username: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        viewModelScope.launch {

            val user = userDao.getUser(username)

            if (user == null) {
                onResult(false, "Usuario no existe")
            } else if (user.password != password) {
                onResult(false, "Contraseña incorrecta")
            } else {
                onResult(true, "Login correcto")
            }
        }
    }
}
