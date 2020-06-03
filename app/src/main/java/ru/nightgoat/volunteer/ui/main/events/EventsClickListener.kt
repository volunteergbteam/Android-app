package ru.nightgoat.volunteer.ui.main.events

interface EventsClickListener {

    fun onCheckCompletedBtnClickListener(eventId: String)
    fun onCancelBtnClickListener(eventId: String)
}