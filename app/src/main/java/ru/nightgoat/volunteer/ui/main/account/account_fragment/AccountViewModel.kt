package ru.nightgoat.volunteer.ui.main.account.account_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.data.network.model.Account
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import javax.inject.Inject

class AccountViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    private val accountMutableLiveData = MutableLiveData<Account>().apply {
        value = Account(
            "Иван Иванович",
            "email@email.ru",
            "Санкт-Петербург",
            "Всегда хотел помогать, и вот, помогаю",
            4.6f
        )
    }
    val accountLiveData: LiveData<Account> = accountMutableLiveData
}