package ru.nightgoat.volunteer.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nightgoat.volunteer.network.model.Account

class AccountViewModel : ViewModel() {

    private val accountMutableLiveData = MutableLiveData<Account>().apply {
        value = Account("Иван Иванович", "email@email.ru", "Всегда хотел помогать, и вот, помогаю", 4.6f)
    }
    val accountLiveData: LiveData<Account> = accountMutableLiveData
}