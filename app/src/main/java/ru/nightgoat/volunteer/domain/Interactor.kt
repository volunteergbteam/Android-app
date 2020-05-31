package ru.nightgoat.volunteer.domain

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import ru.nightgoat.volunteer.data.locationRepo.LocationRepository
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.utils.countDistance
import timber.log.Timber

class Interactor(
    private val repository: Repository,
    private val locationRepository: LocationRepository
) {
    companion object {
        val TAG = Interactor::class.simpleName
    }

    fun register(user: User, password: String): Completable {
        return repository.createUser(user.email, password)
            .andThen(Completable.defer { repository.sendConfirmationEmail() })
            .andThen(Completable.defer { repository.addUserToDatabase(user) })
    }

    fun getEventsByUser(): Flowable<List<EventModel>> {
        Timber.tag(TAG).d("getEvents()")
        return repository.getUser().flatMapPublisher { user -> repository.getEvents(user.city) }
    }

    fun getEventsByGeo(): Flowable<List<EventModel>> {
        return repository.getAreas().zipWith(locationRepository.getLastLocation(),
            BiFunction<List<Area>, LatLng?, Int> { list, currentLocation ->
                return@BiFunction countClosestArea(currentLocation, list).key!!.toInt()
            }).flatMapPublisher { locationId -> repository.getEvents(locationId) }
    }


    fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        status: Int
    ): Completable {
        return repository.getAreas().zipWith(locationRepository.getLastLocation(),
            BiFunction<List<Area>, LatLng?, Int> { list, currentLocation ->
                return@BiFunction countClosestArea(currentLocation, list).key!!.toInt()
            }).flatMapCompletable { locationId ->
            repository.getEvents(locationId).first(listOf()).flatMapCompletable { listOfEvents ->
                repository.addEvent(
                    title,
                    description,
                    latLng,
                    whenEnds,
                    locationId,
                    listOfEvents.size,
                    status
                )
            }
        }
    }

    private fun countClosestArea(currentLatLon: LatLng, areas: List<Area>): Area {
        var closestArea: Area = areas[0]
        for (area in areas) {
            if (countDistance(currentLatLon, LatLng(area.lat, area.lon)) <
                countDistance(currentLatLon, LatLng(closestArea.lat, closestArea.lon))
            )
                closestArea = area
        }
        return closestArea
    }

    fun searchLocation(address: String) : Single<LatLng> {
        return locationRepository.geocodeAndFindClosestLatLntFromString(address)
    }

    fun geocodeAndFindAddressFromLatLng(latlng: LatLng) : Single<String> {
        return locationRepository.geocodeAndFindAddressFromLatLng(latlng)
    }


}







