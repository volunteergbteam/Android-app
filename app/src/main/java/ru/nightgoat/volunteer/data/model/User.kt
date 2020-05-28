package ru.nightgoat.volunteer.data.model

data class User (
    var name: String = "",
    var secondName: String = "",
    var email: String = "",
    var city: Int = -1,
    var phone: String? = "",
    var about: String? = ""
)