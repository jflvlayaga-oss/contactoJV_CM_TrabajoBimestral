package com.example.contactoapp.ui.contacts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.contactoapp.data.Contact
import com.example.contactoapp.viewmodel.ContactViewModel

@Composable
fun ContactListScreen(
    navController: NavController,
    viewModel: ContactViewModel = viewModel()
) {

    val contacts by viewModel.contacts.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_contact") }
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                label = { Text("Buscar contacto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(contacts) { contact ->
                    ContactItem(contact = contact)
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = contact.nombres,
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = contact.telefono)
            Text(text = contact.email)
            Text(text = contact.empresa)
        }
    }
}

