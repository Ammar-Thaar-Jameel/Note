package com.example.note.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.model.database.entity.Note
import com.example.note.model.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {


    val noteText = MutableStateFlow<String?>(null)

    val noteDescription = MutableStateFlow<String?>(null)

    fun addNote() {
        viewModelScope.launch {
            noteText.value?.let {
                Repository.insertNote(Note(0, it, noteDescription.value.toString()))
                noteText.emit("")
                noteDescription.emit("")
            }

        }
    }
}