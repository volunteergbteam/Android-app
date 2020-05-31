package ru.nightgoat.volunteer.data.model

import com.google.firebase.database.Exclude

data class Area (
    @Exclude
    var key: Int? = 0,
    val title: String? = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0
)