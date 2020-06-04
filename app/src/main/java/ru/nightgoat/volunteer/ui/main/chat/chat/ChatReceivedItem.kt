package ru.nightgoat.volunteer.ui.main.chat.chat

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import ru.nightgoat.volunteer.R
import kotlinx.android.synthetic.main.item_chat_received.view.*
import org.joda.time.format.DateTimeFormat
import ru.nightgoat.volunteer.objects.ChatMessage

class ChatReceivedItem(private val message: ChatMessage) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            item_chat_received_body.text = message.message
            item_chat_received_name.text = message.name
            item_chat_received_time.text = DateTimeFormat.shortTime().print(message.timestamp!!)
        }
    }

    override fun getLayout() = R.layout.item_chat_received
}