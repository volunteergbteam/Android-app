package ru.nightgoat.volunteer.ui.main.chat.list

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import ru.nightgoat.volunteer.objects.ChatRoom
import kotlinx.android.synthetic.main.item_chat_list.view.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import ru.nightgoat.volunteer.R
import java.time.format.DateTimeFormatter

class ChatRoomItem(private val chatRoom: ChatRoom) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.apply {
            itemView.chat_list_item_title.text = chatRoom.title
            itemView.chat_list_item_timestamp.text = DateTimeFormat.shortDate().print(chatRoom.timestamp!!)
        }
    }

    override fun getLayout() = R.layout.item_chat_list

    fun getChatRoomEventId() : String {
        return chatRoom.event.toString()
    }
}