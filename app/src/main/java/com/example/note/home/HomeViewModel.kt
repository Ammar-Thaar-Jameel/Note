package com.example.note.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.model.database.entity.Note
import com.example.note.model.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), HomeInteractionListener {


    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

   
    init {
        getAllNotes()
    }


    private fun getAllNotes() {
        viewModelScope.launch {
            Repository.getAllNotes().collect() {
                _notes.emit(it)
            }

        }

    }

}