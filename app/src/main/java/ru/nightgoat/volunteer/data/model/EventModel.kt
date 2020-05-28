package ru.nightgoat.volunteer.data.model

data class EventModel (
    val title: String? = "",
    val description: String? = "",
    val status: Int? = 0,
    val creation_date: Long? = 0,
    val expiration_date: Long? = 0,
    val owner_id: Int? = 0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val priority: Int? = 0
)
