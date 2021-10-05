package com.example.recorder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecordingItem::class], version = 1,exportSchema = false)
abstract class RecordDatabase: RoomDatabase() {
    abstract val recordDatabaseDao: RecordDatabaseDao

    //Позволяет привязать внутри него функцию к классу
    companion object {
        @Volatile
        private var INSTANCE: RecordDatabase? = null

        //Возвращает экземпляр БД
        fun getInstance(context: Context): RecordDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecordDatabase::class.java,
                        "recorder_app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}