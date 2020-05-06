package ru.nightgoat.volunteer.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nightgoat.volunteer.data.entity.EventEntity

@Database(entities = [EventEntity::class], version = 0, exportSchema = false)
abstract class VolunteerDatabase : RoomDatabase() {

    abstract fun dao(): Dao

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