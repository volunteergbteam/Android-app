package ru.nightgoat.volunteer.data.firebase

import android.util.EventLog
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import io.reactivex.*
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.objects.ChatMessage
import ru.nightgoat.volunteer.objects.ChatRoom
import ru.nightgoat.volunteer.utils.*
import timber.log.Timber

class FirebaseDB : Repository {

    private val firebase = Firebase
    private val database = firebase.database.reference
    private val auth = firebase.auth

    companion object {
        val TAG = FirebaseDB::class.java.name
    }

    override fun getEvent(city: Int, eventId: String) : Single<EventModel> {
        val reference = database.child(EVENTS).child(city.toString()).child(eventId)
        return Single.create { emitter ->
            reference.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }
                override fun onDataChange(p0: DataSnapshot) {
                    p0.getValue<EventModel>()?.let { emitter.onSuccess(it) }
                }
            })
        }
    }

    override fun getEvents(locationId: Int): Flowable<List<EventModel>> {
        val eventsReference = database.child(EVENTS).child(locationId.toString())
        return Flowable.create({ emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val list = mutableListOf<EventModel>()
                    for (dataSnapshot in p0.children) {
                        val event = dataSnapshot.getValue<EventModel>()
                        event?.let {
                            list.add(event)
                        }
                    }
                    emitter.onNext(list)
                }
            }
            emitter.setCancellable { eventsReference.removeEventListener(valueEventListener) }
            eventsReference.addValueEventListener(valueEventListener)
        }, BackpressureStrategy.BUFFER)
    }

    override fun getMyEvents(): Flowable<EventModel> {
        return Single.create<MutableMap<String, MutableMap<String, String>>> { emitter ->
            val userRef = database.child(USERS).child(auth.currentUser!!.uid).child("createdEvents")
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }
                override fun onDataChange(p0: DataSnapshot) {
                    val map = p0.getValue<MutableMap<String, MutableMap<String, String>>>()
                    map?.let {
                        Timber.d(it.toString())
                        emitter.onSuccess(it)
                    }
                }
            }
            userRef.addListenerForSingleValueEvent(valueEventListener)
        }.flatMapPublisher { cities ->
            Flowable.create<EventModel>({ emitter ->
                for (cityKey in cities.keys) {
                    cities[cityKey].let { events ->
                        for (eventsKey in events?.values?.toList()!!) {
                            val cityId = cityKey.drop(4)
                            val eventsReference = database.child(EVENTS).child(cityId).child(eventsKey)
                            val valueEventListener = object : ValueEventListener {
                                override fun onCancelled(p0: DatabaseError) {
                                    emitter.onError(p0.toException())
                                }
                                override fun onDataChange(p0: DataSnapshot) {
                                    val event = p0.getValue<EventModel>()
                                    event?.let { emitter.onNext(event) }
                                }
                            }
                            eventsReference.addValueEventListener(valueEventListener)
                        }
                    }
                }
            }, BackpressureStrategy.BUFFER)
        }
    }

    override fun getAreas(): Single<List<Area>> {
        val areasReference = database.child(AREAS)
        return Single.create { emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }

                override fun onDataChange(p0: DataSnapshot) {
                    val listOfAreas = mutableListOf<Area>()
                    p0.children.forEach { dataSnapshot ->
                        val area = dataSnapshot.getValue<Area>()
                        area?.let {
                            area.key = dataSnapshot.key!!.toInt()
                            listOfAreas.add(area)
                        }
                    }
                    emitter.onSuccess(listOfAreas)
                }
            }
            areasReference.addListenerForSingleValueEvent(valueEventListener)
        }
    }

    //Caution! This method gets specific chat room for example purposes!
    override fun getChatList(): Flowable<ChatRoom> {
        val city = "city1"
        Timber.tag("FirebaseDB").d("getChatList call")
        return Flowable.create({ emitter ->
            val reference = database.child(CHATS).child(city)
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val hashMapOfChatRooms = dataSnapshot.getValue<HashMap<String, ChatRoom>>()
                    hashMapOfChatRooms?.let {
                        Timber.tag("FirebaseDB").d(it.toString())
                        for (map in it.asIterable()) {
                            val chatRoom = map.value
                            chatRoom.city = city.drop(4).toInt()
                            chatRoom.event = EventModel(id = map.key)
                            emitter.onNext(chatRoom)
                        }
                    }
                }
            }
            emitter.setCancellable { reference.removeEventListener(valueEventListener) }
            reference.addValueEventListener(valueEventListener)
        }, BackpressureStrategy.BUFFER)
    }

    override fun getChatMessages(eventId: String): Flowable<ChatMessage> {
        Timber.tag(TAG).d("getChatMessages")
        return Flowable.create({ emitter ->
            val reference = database.child(MESSAGES).child(eventId)
            reference.addChildEventListener(object : ChildEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }
                override fun onChildMoved(p0: DataSnapshot, p1: String?) {}
                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }
                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val chatMessage = p0.getValue<ChatMessage>()
                    if (chatMessage != null) {
                        emitter.onNext(chatMessage)
                    }
                }
                override fun onChildRemoved(p0: DataSnapshot) {}
            })
        }, BackpressureStrategy.BUFFER)
    }

    override fun addChatMessage(eventId: String, message: ChatMessage): Completable {
        return Completable.create { emitter ->
            val ref = database.child(MESSAGES).child(eventId).push()
            ref.setValue(message).addOnCompleteListener {
                if (it.isSuccessful) emitter.onComplete()
                else it.exception?.let { exception -> emitter.onError(exception) }
            }
        }
    }


    override fun addUserToDatabase(user: User): Completable {
        return Completable.create { emitter ->
            database.child(USERS).child(auth.currentUser!!.uid).setValue(user)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        emitter.onComplete()
                    } else {
                        it.exception?.let { exception -> emitter.onError(exception) }
                    }
                }
        }
    }

    override fun createUser(email: String, password: String): Completable {
        return Completable.create { emitter ->
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    emitter.onComplete()
                } else {
                    task.exception?.let {
                        emitter.onError(it)
                    }
                }
            }
        }
    }

    override fun sendConfirmationEmail(): Completable {
        val user = auth.currentUser!!
        return Completable.create { emitter ->
            user.sendEmailVerification()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        emitter.onComplete()
                    } else {
                        Timber.e(task.exception, "sendEmailVerification")
                        task.exception?.let { emitter.onError(it) }
                    }
                }
        }
    }

    override fun getUser(): Single<User> {
        val eventsReference = database.child(USERS).child(auth.currentUser!!.uid)
        return Single.create { emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                }

                override fun onDataChange(p0: DataSnapshot) {
                    p0.getValue<User>()?.let { emitter.onSuccess(it) }
                }
            }
            eventsReference.addListenerForSingleValueEvent(valueEventListener)
        }
    }

    override fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        city: Int,
        status: Int,
        address: String
    ): Completable {
        return Single.create<String> { emitter ->
            val reference = database.child(EVENTS).child(city.toString()).push()
            val event = EventModel(
                id = reference.key.toString(),
                title = title,
                description = description,
                status = status,
                creation_date = System.currentTimeMillis(),
                owner_id = auth.currentUser?.uid,
                expiration_date = whenEnds,
                lat = latLng.latitude,
                lon = latLng.longitude,
                address = address
            )
            reference.setValue(event).addOnCompleteListener {
                if (it.isSuccessful) emitter.onSuccess(reference.key.toString())
                else it.exception?.let { it1 -> emitter.onError(it1) }
            }
        }.flatMapCompletable { key ->
            Completable.create { emitter ->
                val userRef =
                    database.child(USERS).child(auth.currentUser!!.uid)
                        .child("createdEvents")
                        .child("city" + city)
                        .push()
                userRef.setValue(key).addOnCompleteListener {
                    if (it.isSuccessful) emitter.onComplete()
                    else it.exception?.let { it1 -> emitter.onError(it1) }
                }
            }
        }
    }
}