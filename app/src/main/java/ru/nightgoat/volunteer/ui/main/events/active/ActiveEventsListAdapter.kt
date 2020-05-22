package ru.nightgoat.volunteer.ui.main.events.active

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nightgoat.volunteer.data.db.entity.UserEventsWishEntity
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener

/**
 * Адаптер для RecyclerView, который содержит список активных мероприятий пользователя.
 * @author NightGoat
 */
class ActiveEventsListAdapter(private val clickListener: EventsClickListener) : RecyclerView.Adapter<ActiveEventsViewHolder>() {

    private var list: List<UserEventsWishEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveEventsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ActiveEventsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ActiveEventsViewHolder, position: Int) {
        val album: UserEventsWishEntity = list[position]
        holder.bind(album, clickListener)
    }

    fun setList(list: List<UserEventsWishEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

}