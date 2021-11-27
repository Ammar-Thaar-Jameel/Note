package com.example.note.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.note.BR

abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {
    abstract fun setup()
    abstract val viewModel: ViewModel
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VDB
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        _binding.setVariable(BR.viewModel, viewModel)
        _binding.lifecycleOwner = this
        setup()
        return _binding.root
    }
}