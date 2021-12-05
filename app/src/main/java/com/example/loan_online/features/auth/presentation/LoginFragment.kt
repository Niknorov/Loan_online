package com.example.loan_online.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.loan_online.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uISateLivedata.observe(
            viewLifecycleOwner
        ) {
            //progressbar and perehod
            when (it) {
                LoginUiState.ERROR_INVALID_CREDENCE ->
                    Toast.makeText(
                        context,
                        "Invalid login or password",
                        Toast.LENGTH_SHORT
                    ).show()


                LoginUiState.ERROR_EMPTY_INPUT -> Toast.makeText(
                    context,
                    "Empty login or password",
                    Toast.LENGTH_SHORT
                ).show()

                LoginUiState.ERROR_USER_EXIST -> Toast.makeText(
                    context,
                    "This user is already exist ", Toast.LENGTH_SHORT
                ).show()

                LoginUiState.PROGRESS -> binding.progressBar.isVisible = true

            }
        }
        val login = binding.login.editText?.text
        val password = binding.password.editText?.text

        binding.signIn.setOnClickListener {
            viewModel.launchAuth(login.toString(), password.toString())
        }
        binding.registration.setOnClickListener {
            viewModel.launchRegistration(login.toString(), password.toString())
        }

    }
}