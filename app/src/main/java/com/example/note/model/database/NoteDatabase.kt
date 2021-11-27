package com.example.note.model.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.note.model.database.dao.NoteDao
import com.example.note.model.database.entity.Note

@Database(entities = [Note::class], version = 1)
@TypeConverters(com.example.note.model.database.Converters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao


    companion object {
        private const val DB_NAME = "DB_NOTE"

        @Volatile
        private var instance: NoteDatabase? = null

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, DB_NAME).build()
        }

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
        }

        val getInstance get() = instance!!
    }
}