package ru.nightgoat.volunteer.network.model

import ru.nightgoat.volunteer.utils.EventType

data class EventModel (
    val id: Int,
    val title: String,
    val creationDate: Long,
    val type: EventType,
    val description: String,
    val eventDate: Long,
    val isOver: Boolean,
    val ownerId: Int,
    val inProgress: Boolean,
    val locationId: Int,
    val locationLon: Float,
    val locationLat: Float
)