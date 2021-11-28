package com.example.note.model.database.dao

import androidx.room.*
import com.example.note.model.database.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM TB_NOTE ORDER BY noteId DESC")
    fun getAllNotes(): Flow<List<Note>>
}