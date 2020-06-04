package ru.nightgoat.volunteer.ui.main.map

import com.google.android.gms.maps.model.LatLng
import ru.nightgoat.volunteer.data.model.EventModel

interface ParentFragment {
    fun moveMapTo(destination: LatLng)
    fun closeBottomPanel()
    fun goToChat(event: EventModel)
}
