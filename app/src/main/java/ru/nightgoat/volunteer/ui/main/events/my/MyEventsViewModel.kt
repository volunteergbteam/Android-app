package ru.nightgoat.volunteer.ui.main.events.my

import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener
import javax.inject.Inject

class MyEventsViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel(),
    EventsClickListener {
    override fun onCheckCompletedBtnClickListener(eventId: Int) {

    }

    override fun onCancelBtnClickListener(eventId: Int) {

    }
}