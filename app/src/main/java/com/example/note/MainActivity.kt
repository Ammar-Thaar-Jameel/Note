package com.example.note

import android.os.Bundle
import androidx.activity.viewModels
import com.example.note.base.BaseActivity
import com.example.note.databinding.ActivityMainBinding
import com.example.note.model.database.NoteDatabase

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_Note
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NoteDatabase.getInstance(applicationContext)
    }

}