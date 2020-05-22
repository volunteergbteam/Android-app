package ru.nightgoat.volunteer.data.network.model

data class Account (
    var firstName: String,
    var secondName: String,
    var email: String,
    var city: String,
    var about: String,
    var rating: Float
) {
    var password: String = "password"
}