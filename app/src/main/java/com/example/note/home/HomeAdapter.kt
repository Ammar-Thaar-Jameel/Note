package com.example.note.home

import com.example.note.R
import com.example.note.base.BaseAdapter
import com.example.note.model.database.entity.Note

class HomeAdapter(list: List<Note>, listener: HomeInteractionListener) :
    BaseAdapter<Note>(list, listener) {
    override val layoutID = R.layout.item_note
}
