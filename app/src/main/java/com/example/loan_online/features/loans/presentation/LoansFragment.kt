package com.example.loan_online.features.loans.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loan_online.R
import com.example.loan_online.databinding.FragmentLoansBinding


class LoansFragment : Fragment() {

    private lateinit var binding: FragmentLoansBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoansBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createButton.setOnClickListener {
            findNavController().navigate(R.id.action_loansFragment_to_createLoanFragment)
        }

    }
}