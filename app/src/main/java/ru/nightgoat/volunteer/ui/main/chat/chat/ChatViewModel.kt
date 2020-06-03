package ru.nightgoat.volunteer.ui.main.chat.chat

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.objects.ChatMessage
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    private val messagesMutableLiveData = MutableLiveData<ChatMessage>()
    val messagesLiveData = messagesMutableLiveData

    private var userId: String = Firebase.auth.uid.toString()
    private lateinit var userName: String

    fun listenToMessages(eventId: String) {
        compositeDisposable.add(
            interactor.getChatMessages(eventId).subscribe({
                messagesMutableLiveData.value = it
            }, {

            })
        )
    }

    fun sendMessage(eventId: String, message: String) {
        val chatMessage = ChatMessage(userId, userName, message, System.currentTimeMillis())
        compositeDisposable.add(
            interactor.sendMessage(eventId, chatMessage).subscribe({
                Timber.d("Message sent")
            }, {
                Timber.e(it)
            })
        )
    }

    fun getUser() {
        compositeDisposable.add(
            interactor.getUser().subscribe({ user ->
                userName = user.name
            }, {

            }
            )
        )
    }
}
