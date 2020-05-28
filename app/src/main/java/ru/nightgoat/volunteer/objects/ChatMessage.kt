package ru.nightgoat.volunteer.objects

import java.util.*

data class ChatMessage(
    val userName: String,
    val textMessage: String,
    val messageTime: Long = Date().time
)