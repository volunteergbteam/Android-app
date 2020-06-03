package ru.nightgoat.volunteer.objects

import com.google.firebase.database.Exclude

data class ChatRoom(
    val title: String? = "",
    val timestamp: Long? = 0,
    @Exclude
    var event: String? = ""
)