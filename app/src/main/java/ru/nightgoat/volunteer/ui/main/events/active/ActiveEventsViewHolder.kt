package ru.nightgoat.volunteer.ui.main.events.active

import kotlinx.android.synthetic.main.item_events_active.view.*

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.db.entity.UserEventsWishEntity
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener

/**
 * ViewHolder для RecyclerView, который содержит список активных мероприятий пользователя
 * @author NightGoat
 */
class ActiveEventsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_events_active, parent, false)) {

    fun bind(event: EventModel, clickListener: EventsClickListener) {
        itemView.item_events_active_text_title.text = event.title
        itemView.item_events_active_text_description.text = event.description
        itemView.item_events_active_text_address.text = event.address
        itemView.item_events_active_text_name.text = event.owner_id
        itemView.item_events_active_btn_check_completed.setOnClickListener {
            clickListener.onCheckCompletedBtnClickListener(event.id)
        }
        itemView.item_events_active_btn_cancel.setOnClickListener {
            clickListener.onCancelBtnClickListener(event.id)
        }
    }
}