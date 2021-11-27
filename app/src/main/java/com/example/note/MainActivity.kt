package com.example.note

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.example.note.base.BaseActivity
import com.example.note.databinding.ActivityMainBinding
import com.example.note.model.database.NoteDatabase
import com.example.note.util.onNavDestinationSelected

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_Note
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NoteDatabase.getInstance(applicationContext)
    }


    override fun onResume() {
        super.onResume()
        initNavBar()
    }

    private fun initNavBar() {
        val navController = findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.apply {
            addBubbleListener { id ->
                onNavDestinationSelected(id, navController)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.setSelectedWithId(destination.id, false)
            }
        }
    }
}