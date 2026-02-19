package com.example.contactoapp.ui.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.contactoapp.data.Contact
import com.example.contactoapp.viewmodel.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreen(
    navController: NavController,
    contactId: Int,
    viewModel: ContactViewModel = viewModel()
) {

    val contacts by viewModel.contacts.collectAsState()
    val contact = contacts.find { it.id == contactId }

    if (contact == null) {
        Text("Contacto no encontrado")
        return
    }

    var nombres by remember { mutableStateOf(contact.nombres) }
    var telefono by remember { mutableStateOf(contact.telefono) }
    var email by remember { mutableStateOf(contact.email) }
    var empresa by remember { mutableStateOf(contact.empresa) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Editar Contacto") })
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = nombres,
                onValueChange = { nombres = it },
                label = { Text("Nombres") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = empresa,
                onValueChange = { empresa = it },
                label = { Text("Empresa") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    viewModel.update(
                        Contact(
                            id = contact.id,
                            nombres = nombres,
                            telefono = telefono,
                            email = email,
                            empresa = empresa
                        )
                    )
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar")
            }
        }
    }
}
