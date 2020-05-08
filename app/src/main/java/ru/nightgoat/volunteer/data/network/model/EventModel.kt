package ru.nightgoat.volunteer.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventModel (
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("type")
    @Expose
    val type: String,

    @SerializedName("creationDate")
    @Expose
    val creationDate: Long,

    @SerializedName("eventDate")
    @Expose
    val eventDate: Long,

    @SerializedName("ownerId")
    @Expose
    val ownerId: Int,

    @SerializedName("inProgress")
    @Expose
    val inProgress: Boolean,

    @SerializedName("locationLon")
    @Expose
    val locationLon: Double,

    @SerializedName("locationLat")
    @Expose
    val locationLat: Double,

    @SerializedName("over")
    @Expose
    val isOver: Boolean
)
