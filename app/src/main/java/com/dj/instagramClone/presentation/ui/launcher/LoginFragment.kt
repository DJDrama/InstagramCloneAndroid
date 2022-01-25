package com.dj.instagramClone.presentation.ui.launcher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dj.instagramClone.R
import com.dj.instagramClone.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        initViews()
    }

    private fun initViews() {
        binding.tvLanguage.setOnClickListener(this)
        binding.ivDown.setOnClickListener(this)
        binding.tvForgot.setOnClickListener(this)
        binding.tvHelpLogIn.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
        binding.ivLoginWithFacebook.setOnClickListener(this)
        binding.btnCreateNewAccount.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it) {
                binding.tvLanguage, binding.ivDown->{

                }
                binding.tvForgot, binding.tvHelpLogIn -> {
                }
                binding.btnLogin -> {
                }
                binding.ivLoginWithFacebook -> {
                }
                binding.btnCreateNewAccount -> {
                }
            }
        }
    }
}