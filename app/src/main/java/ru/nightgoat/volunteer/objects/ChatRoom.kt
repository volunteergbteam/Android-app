package ru.nightgoat.volunteer.objects

import com.google.firebase.database.Exclude
import ru.nightgoat.volunteer.data.model.EventModel

data class ChatRoom(
    val title: String? = "",
    val timestamp: Long? = 0,
    val address: String? = "",
    @Exclude
    var city: Int? = 0,
    @Exclude
    var event: EventModel? = EventModel()
)