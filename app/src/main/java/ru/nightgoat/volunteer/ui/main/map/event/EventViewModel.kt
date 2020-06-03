package ru.nightgoat.volunteer.ui.main.map.event

import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import ru.nightgoat.volunteer.ui.main.map.ParentFragment
import java.lang.Exception
import javax.inject.Inject

class EventViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    private val isChatCreatedMutableLiveData = MutableLiveData<Boolean>()
    val isChatCreatedLiveData = isChatCreatedMutableLiveData
    private val exceptionMutableLiveData = MutableLiveData<String>()
    val exceptionLiveData = exceptionMutableLiveData


    fun onHelpBtnClick(event : EventModel, parentFragment: ParentFragment){
        compositeDisposable.add(
            interactor.help(event).subscribe({
                parentFragment.goToChat(event)
            }, {
                exceptionMutableLiveData.value = it.message
            })
        )
    }
}