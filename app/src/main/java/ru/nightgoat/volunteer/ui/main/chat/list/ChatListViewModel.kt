package ru.nightgoat.volunteer.ui.main.chat.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.objects.ChatRoom
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ChatListViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    companion object {
        private val TAG = ChatListViewModel::class.java.name
    }

    private val mutableLiveData = MutableLiveData<List<ChatRoom>>()
    val liveData : LiveData<List<ChatRoom>> = mutableLiveData

    fun getChatList(){
        compositeDisposable.add(
            interactor.getChatList().subscribe({
                mutableLiveData.value = it
            }, {
                Timber.tag("TAG").e(it)
            }))
    }
}