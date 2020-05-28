package ru.nightgoat.volunteer.data.network

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.nightgoat.volunteer.data.model.LocationEventsModel

interface API {

    @GET("events?")
    fun getEventsForCity(
        @Query("locationId") locationId: Int
    ): Single<LocationEventsModel>

    @POST("register?")
    fun registerAccount(
        @Query("first_name") firstName: String,
        @Query("second_name") secondName: String,
        @Query("email") email: String,
        @Query("city") city: String,
        @Query("about") about: String,
        @Query("password") password: String
    ) : Completable
}