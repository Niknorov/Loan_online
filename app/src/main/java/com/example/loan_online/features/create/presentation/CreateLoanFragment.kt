package com.example.loan_online.features.create.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loan_online.R
import com.example.loan_online.databinding.FragmentCreateLoanBinding
import com.example.loan_online.databinding.FragmentLoansBinding
import com.example.loan_online.features.create.domain.ConditionsModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CreateLoanFragment : Fragment() {

    private lateinit var binding: FragmentCreateLoanBinding
    private val viewModel: CreationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateLoanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getConditions()
        viewModel.conditionsLiveData.observe(
            viewLifecycleOwner
        ) {
            binding.maxAmount.text = getString(R.string.maxAmount, it.maxAmount)
            binding.percent.text = getString(R.string.percent, it.percent)
            binding.period.text = getString(R.string.period, it.period)
        }

    }
}
