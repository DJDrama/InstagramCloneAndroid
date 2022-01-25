package com.dj.instagramClone.presentation.ui.launcher

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dj.instagramClone.R
import com.dj.instagramClone.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {
    private val viewModel by viewModels<LoginViewModel>()

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        initViews()
        subscribeToObservers()
    }

    private fun initViews() {
        binding.tvLanguage.setOnClickListener(this)
        binding.ivDown.setOnClickListener(this)
        binding.tvForgot.setOnClickListener(this)
        binding.tvHelpLogIn.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
        binding.ivLoginWithFacebook.setOnClickListener(this)
        binding.btnCreateNewAccount.setOnClickListener(this)


        binding.etId.doAfterTextChanged {
            viewModel.setCredentials(id = it.toString())
        }
        binding.etPassword.doAfterTextChanged {
            viewModel.setCredentials(password = it.toString())
        }
    }

    private fun subscribeToObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.credentialUiState.collect {
                    when (it) {
                        CredentialUiState.BothFilled -> {
                            setButtonLoginClickableWithAlphaOne()
                        }
                        CredentialUiState.BothNotFilled -> {
                            setButtonLoginNotClickableWithAlphaPointThree()
                        }
                    }
                }
            }
        }
    }

    private fun setButtonLoginClickableWithAlphaOne() {
        binding.btnLogin.alpha = 1.0f
        binding.btnLogin.isClickable = true
    }

    private fun setButtonLoginNotClickableWithAlphaPointThree() {
        binding.btnLogin.alpha = 0.35f
        binding.btnLogin.isClickable = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it) {
                binding.tvLanguage, binding.ivDown -> {
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