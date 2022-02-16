package com.fasoh.unrd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class UnrdDatabase : RoomDatabase() {


    companion object {
        private var database: UnrdDatabase? = null

        fun getInstance(context: Context): UnrdDatabase {
            database?.let {
                return database!!
            }
            return Room.databaseBuilder(context, UnrdDatabase::class.java, "unrd-database").build()
        }
    }
}