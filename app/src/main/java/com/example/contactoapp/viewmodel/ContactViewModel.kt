package com.example.contactoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactoapp.data.Contact
import com.example.contactoapp.database.AppDatabase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao = AppDatabase.getDatabase(application).contactDao()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val contacts: StateFlow<List<Contact>> =
        _searchQuery
            .debounce(300)
            .flatMapLatest { query ->
                if (query.isBlank()) {
                    contactDao.getAllContacts()
                } else {
                    contactDao.searchContacts(query)
                }
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun insert(contact: Contact) {
        viewModelScope.launch {
            contactDao.insert(contact)
        }
    }

    fun delete(contact: Contact) {
        viewModelScope.launch {
            contactDao.delete(contact)
        }
    }
}

