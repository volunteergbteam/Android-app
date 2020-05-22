package ru.nightgoat.volunteer.ui.main.events

interface EventsClickListener {

    fun onCheckCompletedBtnClickListener(eventId: Int)
    fun onCancelBtnClickListener(eventId: Int)
}