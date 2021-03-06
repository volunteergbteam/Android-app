package ru.nightgoat.volunteer.ui.main.events.active

import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener
import javax.inject.Inject

class ActiveEventsViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel(),
    EventsClickListener {
    override fun onCheckCompletedBtnClickListener(eventId: String) {

    }

    override fun onCancelBtnClickListener(eventId: String) {

    }
}
