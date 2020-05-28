package ru.nightgoat.volunteer.domain

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import timber.log.Timber
import java.util.function.Function

class Interactor(private val repository: Repository) {

    fun register(user: User, password: String) : Completable {
        return repository.createUser(user.email, password)
            .andThen(Completable.defer { repository.sendConfirmationEmail()})
            .andThen(Completable.defer { repository.addUserToDatabase(user)})
    }

    fun getEvents() : Flowable<List<EventModel>> {
        Timber.tag(TAG).d("getEvents()")
        return repository.getUser().flatMapPublisher { user -> repository.getEvents(user.city) }
    }

    companion object {
        val TAG = Interactor::class.simpleName
    }
}


