package com.example.loan_online.features.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loan_online.R
import com.example.loan_online.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.startTransition()

        splashViewModel.splashLiveData.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                SplashState.GOTOLOGIN -> {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
                SplashState.GOTOLOANS -> {
                    findNavController().navigate(R.id.action_splashFragment_to_loansFragment)
                }

            }
        }
    }
}