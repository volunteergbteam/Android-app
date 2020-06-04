package ru.nightgoat.volunteer.data.model

import com.google.firebase.database.Exclude

data class User (
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String? = "",
    var about: String? = "",
    var createdEvents: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
)