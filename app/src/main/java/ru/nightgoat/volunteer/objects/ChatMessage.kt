package ru.nightgoat.volunteer.objects

import java.util.*

data class ChatMessage(
    val fromId: String? = "",
    val name: String? = "",
    val message: String? = "",
    val timestamp: Long? = Date().time
)