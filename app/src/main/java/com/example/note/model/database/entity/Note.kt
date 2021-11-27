package com.example.note.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_NOTE")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val noteId: Long,
    val titel: String,

    )

