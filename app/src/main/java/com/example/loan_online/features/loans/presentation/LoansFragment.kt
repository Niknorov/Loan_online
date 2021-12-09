package com.example.loan_online.features.loans.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loan_online.R
import com.example.loan_online.databinding.FragmentLoansBinding
import com.example.loan_online.databinding.SheetLoanBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoansFragment : Fragment() {

    private val loansViewModel: LoansViewModel by viewModel()
    private lateinit var binding: FragmentLoansBinding
    private lateinit var sheetLoanBinding: SheetLoanBinding

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

        binding.loansRecyclerView.layoutManager = LinearLayoutManager(context)

        loansViewModel.loanDataLiveData.observe(viewLifecycleOwner) {

            sheetLoanBinding.phoneNumber.text = it.state.toString()
            sheetLoanBinding.lastName.text = it.lastName
            sheetLoanBinding.firstName.text = it.firstName
            sheetLoanBinding.amount.text = it.amount.toString()
            sheetLoanBinding.date.text = it.date
            sheetLoanBinding.percent.text = it.percent.toString()
            sheetLoanBinding.period.text = it.period.toString()
            sheetLoanBinding.phoneNumber.text = it.phoneNumber
        }


        loansViewModel.loansLiveData.observe(viewLifecycleOwner) {

            val adapter = LoansRecyclerAdapter(it)
            binding.loansRecyclerView.adapter = adapter
            adapter.onItemClick = {

                sheetLoanBinding = SheetLoanBinding.inflate(layoutInflater)

                val dialog = BottomSheetDialog(requireContext())
                dialog.setContentView(sheetLoanBinding.root)
                dialog.show()

                loansViewModel.getLoanData(it.id)
            }
        }
        loansViewModel.getLoans()


    }
}