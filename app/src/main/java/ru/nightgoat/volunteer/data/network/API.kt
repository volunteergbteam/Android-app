package ru.nightgoat.volunteer.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.nightgoat.volunteer.data.network.model.LocationEventsModel

interface API {

    @GET("events?")
    fun getEventsForCity(
        @Query("locationId") locationId: Int
    ): Single<LocationEventsModel>
}