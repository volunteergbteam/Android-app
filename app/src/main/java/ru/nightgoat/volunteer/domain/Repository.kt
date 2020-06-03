package ru.nightgoat.volunteer.domain

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.objects.ChatMessage
import ru.nightgoat.volunteer.objects.ChatRoom

interface Repository {

    fun getEvents(locationId: Int) : Flowable<List<EventModel>>
    fun getMyEvents() : Flowable<EventModel>

    fun addUserToDatabase(user: User) : Completable

    fun createUser(email: String, password: String) : Completable

    fun sendConfirmationEmail() : Completable

    fun getUser() : Single<User>

    fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        city: Int,
        status: Int,
        address: String
    ) : Completable

    fun getAreas() : Single<List<Area>>
    fun getChatList() : Flowable<List<ChatRoom>>
    fun getChatMessages(eventId: String) : Flowable<ChatMessage>
    fun addChatMessage(eventId: String, message : ChatMessage) : Completable
}