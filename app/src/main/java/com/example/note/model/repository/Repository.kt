package com.example.note.model.repository

import com.example.note.model.database.NoteDatabase
import com.example.note.model.database.entity.Note

object Repository {


    private val noteDao = NoteDatabase.getInstance.noteDao

   suspend fun insertNote(note: Note) = noteDao.insert(note)
}