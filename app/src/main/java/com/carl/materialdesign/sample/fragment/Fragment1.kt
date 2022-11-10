package com.carl.materialdesign.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carl.materialdesign.sample.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding?  = null

    private val binding
            get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}