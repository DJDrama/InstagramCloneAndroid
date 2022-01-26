package com.dj.instagramClone.presentation.ui.launcher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dj.instagramClone.R
import com.dj.instagramClone.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration), View.OnClickListener {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding: FragmentRegistrationBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegistrationBinding.bind(view)
        initViews()
    }

    private fun initViews(){
        binding.tvLogIn.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        p0?.let{
            when(it){
                binding.tvLogIn->{
                    findNavController().popBackStack()
                }
                else -> {}
            }
        }
    }
}