package com.example.note.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.note.BR
import com.example.note.model.database.NoteDatabase

abstract class BaseActivity <VDB : ViewDataBinding> : AppCompatActivity() {

    abstract val theme: Int
    abstract val viewID: Int
    abstract val viewModel: ViewModel
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, viewID)
        _binding.setVariable(BR.viewModel,viewModel)
        _binding.lifecycleOwner = this

    }

}