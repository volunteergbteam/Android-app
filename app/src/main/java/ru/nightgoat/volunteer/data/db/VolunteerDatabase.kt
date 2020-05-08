package ru.nightgoat.volunteer.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nightgoat.volunteer.data.db.entity.LocationEventsEntity

@Database(entities = [LocationEventsEntity::class], version = 1, exportSchema = false)
abstract class VolunteerDatabase : RoomDatabase() {

    abstract fun dao(): mDao

    companion object {

        @Volatile
        private var instance: VolunteerDatabase? = null

        fun getInstance(context: Context): VolunteerDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDataBase(
                        context
                    ).also {
                    instance = it
                }
            }
        }

        private fun buildDataBase(context: Context): VolunteerDatabase {
            return Room.databaseBuilder(
                context,
                VolunteerDatabase::class.java, "DB.db"
            )
                .build()
        }

    }
}