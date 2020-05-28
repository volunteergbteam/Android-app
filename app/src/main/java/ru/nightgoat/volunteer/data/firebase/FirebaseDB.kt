package ru.nightgoat.volunteer.data.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import io.reactivex.*
import io.reactivex.functions.Cancellable
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.extentions.showShortToast
import ru.nightgoat.volunteer.utils.*
import timber.log.Timber

class FirebaseDB :  Repository {

    private val firebase = Firebase
    private val database = firebase.database.reference
    private val auth = firebase.auth

    override fun getEvents(locationId: Int): Flowable<List<EventModel>> {
        val eventsReference = database.child(EVENTS).child(locationId.toString())
        return Flowable.create({ emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    val listOfEvents = mutableListOf<EventModel>()
                    for (eventSnapShot in p0.children) {
                        with (eventSnapShot) {
                            val event = getValue<EventModel>()
                            event?.let {
                                listOfEvents.add(it)
                            }
                        }
                    }
                    emitter.onNext(listOfEvents)
                }
            }
            emitter.setCancellable { eventsReference.removeEventListener(valueEventListener) }
            eventsReference.addValueEventListener(valueEventListener)
        }, BackpressureStrategy.BUFFER)
    }

    override fun addUserToDatabase(user: User): Completable {
        return Completable.create { emitter ->
            database.child(USERS).child(auth.currentUser!!.uid).setValue(user).addOnCompleteListener {
                if (it.isSuccessful) {
                    emitter.onComplete()
                } else {
                    it.exception?.let { exception -> emitter.onError(exception) }
                }
            }
        }
    }

    override fun createUser(email: String, password: String) : Completable {
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
}