package com.example.contactoapp.database

import androidx.room.*
import com.example.contactoapp.data.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY nombres ASC")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts WHERE nombres LIKE '%' || :query || '%'")
    fun searchContacts(query: String): Flow<List<Contact>>
}

