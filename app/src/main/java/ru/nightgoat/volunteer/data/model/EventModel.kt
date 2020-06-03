package ru.nightgoat.volunteer.data.model

import com.google.firebase.database.Exclude

data class EventModel (
    val id: String = "",
    val title: String? = "",
    val description: String? = "",
    val status: Int? = 0,
    val creation_date: Long? = 0,
    val expiration_date: Long? = 0,
    val owner_id: String? = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val priority: Int? = 0,
    val address: String? = ""
)
