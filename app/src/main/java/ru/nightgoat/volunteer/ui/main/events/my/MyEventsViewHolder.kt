package ru.nightgoat.volunteer.ui.main.events.my

import kotlinx.android.synthetic.main.item_events_my.view.*

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.db.entity.UserEventsNeedEntity
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener

/**
 * ViewHolder для RecyclerView, который содержит список созданных мероприятий пользователя
 * @author NightGoat
 */
class MyEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_events_my, parent, false)) {

    fun bind(event: EventModel, clickListener: EventsClickListener) {
        itemView.item_events_my_text_title.text = event.title
        itemView.item_events_my_text_description.text = event.description
        itemView.item_events_my_text_address.text = event.address
        itemView.item_events_my_btn_check_completed.setOnClickListener {
            clickListener.onCheckCompletedBtnClickListener(event.id)
        }
        itemView.item_events_my_btn_delete.setOnClickListener {
            clickListener.onCancelBtnClickListener(event.id)
        }
    }
}