package ru.nightgoat.volunteer.ui.main.events.my

import androidx.lifecycle.ViewModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import javax.inject.Inject

class MyEventsViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {
}
