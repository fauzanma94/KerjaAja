package com.animebiru.kerjaaja.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.animebiru.kerjaaja.R
import com.animebiru.kerjaaja.databinding.FragmentLoginBinding
import com.animebiru.kerjaaja.domain.utils.viewBindings
import com.animebiru.kerjaaja.presentation.viewmodels.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBindings(FragmentLoginBinding::bind)
    private val authenticationViewModel: AuthenticationViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setupWithEditText(etlUsername, etlPassword)
            btnLogin.setOnClickListener { onButtonLoginClicked() }
            btnRegister.setOnClickListener { onButtonRegisterClicked() }
        }

    }

    private fun onButtonLoginClicked() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        authenticationViewModel.login(username, password)
    }

    private fun onButtonRegisterClicked() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }
}