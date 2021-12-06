package com.example.loan_online.features.create.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loan_online.databinding.FragmentCreateLoanBinding
import com.example.loan_online.databinding.FragmentLoansBinding


class CreateLoanFragment : Fragment() {

    private lateinit var binding: FragmentCreateLoanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateLoanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
