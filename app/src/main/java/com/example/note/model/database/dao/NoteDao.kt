package com.example.note.model.database.dao

import androidx.room.*
import com.example.note.model.database.entity.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
//
//    @Query("SELECT * FROM TB_USER WHERE userId==:id")
//    fun getUserById(id :Long?): Observable<User>
}