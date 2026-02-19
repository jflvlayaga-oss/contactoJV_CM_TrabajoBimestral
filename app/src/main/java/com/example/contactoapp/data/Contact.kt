package com.example.contactoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nombres: String,
    val telefono: String,
    val email: String,
    val empresa: String
)
