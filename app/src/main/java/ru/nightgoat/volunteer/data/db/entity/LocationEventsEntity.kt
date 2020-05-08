package ru.nightgoat.volunteer.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.nightgoat.volunteer.utils.EventType

@Entity
data class LocationEventsEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val title: String,
    val creationDate: Long,
    val type: String,
    val description: String,
    val eventDate: Long,
    val isOver: Boolean,
    val ownerId: Int,
    val inProgress: Boolean,
    val locationId: Int,
    val locationLon: Float,
    val locationLat: Float
)