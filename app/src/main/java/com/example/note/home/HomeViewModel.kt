package com.example.note.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.model.database.entity.Note
import com.example.note.model.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {

    val noteText = MutableLiveData<String?>()




    fun addNote(){
        viewModelScope.launch {
            noteText.value?.let {
                Repository.insertNote(Note(0,it))
            }
        }
    }

}