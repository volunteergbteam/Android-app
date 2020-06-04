package ru.nightgoat.volunteer.ui.login.register


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {
    private val isRegisteredMutableLiveData = MutableLiveData<Boolean>()
    val isRegisteredLiveData : LiveData<Boolean> = isRegisteredMutableLiveData

    fun createUser(user: User, password: String) {
        compositeDisposable.add(
            interactor.register(user, password).subscribe({
                isRegisteredMutableLiveData.value = true
            }, {
                isRegisteredMutableLiveData.value = false
                Timber.e(it)
            })
        )
    }
}
