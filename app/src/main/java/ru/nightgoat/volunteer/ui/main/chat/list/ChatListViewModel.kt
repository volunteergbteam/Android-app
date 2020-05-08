package ru.nightgoat.volunteer.ui.main.chat.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import javax.inject.Inject

class ChatListViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {
}