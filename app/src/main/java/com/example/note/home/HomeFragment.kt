package com.example.note.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.note.R
import com.example.note.base.BaseFragment
import com.example.note.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {

        binding.homeRecycler.adapter = HomeAdapter(emptyList(), viewModel)

        binding.floatingActionButton.setOnClickListener { view ->

            onNavigateToAddNote(view)
        }


    }

    private fun onNavigateToAddNote(view: View) {

        Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_addNoteFragment)
    }

}