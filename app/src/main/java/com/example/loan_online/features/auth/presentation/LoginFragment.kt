package com.example.loan_online.features.auth.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.loan_online.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {


    private val viewModel: AuthViewModel by viewModel()
    private val loginButton: Button? = view?.findViewById(R.id.login)
    private val loginEditText: EditText? = view?.findViewById(R.id.login)
    private val passwordEditText: EditText? = view?.findViewById(R.id.password)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.livedata.observe(
            this
        ) {

            val login = loginEditText?.text
            val password = passwordEditText?.text
            loginButton?.setOnClickListener {
                viewModel.launchAuth(login.toString(), password.toString())

            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }


}