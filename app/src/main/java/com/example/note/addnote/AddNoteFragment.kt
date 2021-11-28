package com.example.note.addnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.note.R
import com.example.note.base.BaseFragment
import com.example.note.databinding.FragmentAddNoteBinding

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>() {


    override val viewModel: AddNoteViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAddNoteBinding
        get() = FragmentAddNoteBinding::inflate

    override fun setup() {
        binding.back.setOnClickListener { view ->

            onNavigateToHome(view)
        }
    }

    private fun onNavigateToHome(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_addNoteFragment_to_homeFragment2)
    }



}