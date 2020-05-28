package ru.nightgoat.volunteer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationEventsModel (
    @SerializedName("locationId")
    @Expose
    val locationId: Int,

    @SerializedName("eventsList")
    @Expose
    val eventsList: List<EventModel>
)