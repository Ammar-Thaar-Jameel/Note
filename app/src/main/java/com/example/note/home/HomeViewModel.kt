package com.example.note.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.model.database.entity.Note
import com.example.note.model.repository.Repository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), HomeInteractionListener {


    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes


    init {
        getAllNotes()
    }


    private fun getAllNotes() {
        viewModelScope.launch {
            Repository.getAllNotes().collect {
                _notes.postValue(it)
            }

        }

    }

}