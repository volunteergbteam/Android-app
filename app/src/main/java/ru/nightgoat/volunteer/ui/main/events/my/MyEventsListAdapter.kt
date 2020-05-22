package ru.nightgoat.volunteer.ui.main.events.my

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nightgoat.volunteer.data.db.entity.UserEventsNeedEntity
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener

/**
 * Адаптер для RecyclerView, который содержит список созданных мероприятий пользователя.
 * @author NightGoat
 */
class MyEventsListAdapter(private val clickListener: EventsClickListener) : RecyclerView.Adapter<MyEventsViewHolder>() {

    private var list: List<UserEventsNeedEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEventsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyEventsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyEventsViewHolder, position: Int) {
        val event: UserEventsNeedEntity = list[position]
        holder.bind(event, clickListener)
    }

    fun setList(list: List<UserEventsNeedEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

}