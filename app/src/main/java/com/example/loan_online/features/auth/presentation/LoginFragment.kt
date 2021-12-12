package com.example.loan_online.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loan_online.R
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

            when (it) {
                LoginUiState.ERROR_INVALID_CREDENCE -> {
                    Toast.makeText(
                        context,
                        getString(R.string.invalid_login_or_password),
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.progressBar.isVisible = false
                }
                LoginUiState.ERROR_NETWORK -> {

                    Toast.makeText(context, R.string.network_error, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }


                LoginUiState.ERROR_EMPTY_INPUT -> {
                    Toast.makeText(
                        context,
                        getString(R.string.empty_login_or_password),
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.progressBar.isVisible = false
                }

                LoginUiState.ERROR_USER_EXIST -> {
                    Toast.makeText(
                        context,
                        getString(R.string.this_user_is_already_exist), Toast.LENGTH_SHORT
                    ).show()
                    binding.progressBar.isVisible = false
                }

                LoginUiState.PROGRESS -> binding.progressBar.isVisible = true
                LoginUiState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    findNavController().navigate(
                        R.id.action_loginFragment_to_loansFragment
                    )
                }
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