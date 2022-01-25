package com.dj.instagramClone.presentation.ui.launcher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.dj.instagramClone.R
import com.dj.instagramClone.databinding.FragmentIntroBinding
import com.dj.instagramClone.presentation.ui.main.MainActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class IntroFragment : Fragment(R.layout.fragment_intro) {
    private val viewModel: IntroViewModel by viewModels()
    private var _binding: FragmentIntroBinding? = null
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentIntroBinding.bind(view)
        initViews()
        subscribeToFlows()
    }

    private fun initViews() {
    }

    private fun subscribeToFlows() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.introUiState.collect {
                    when (it) {
                        is IntroUiState.LoadComplete -> {
                            navigateToLoginFragment()
                        }
                        is IntroUiState.Loading -> {
                        }
                    }
                }
            }
        }
    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.action_introFragment_to_loginFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}