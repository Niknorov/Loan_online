package com.example.loan_online.features.loans.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loan_online.R
import com.example.loan_online.common.formatDate
import com.example.loan_online.databinding.FragmentLoansBinding
import com.example.loan_online.databinding.SheetLoanBinding
import com.example.loan_online.features.create.domain.LoanState
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

            if (it.state == LoanState.REGISTERED) {
                sheetLoanBinding.state.text = getString(R.string.stateString, it.state.toString())
                sheetLoanBinding.state.setTextColor(Color.parseColor("#FCD12A"))

            } else if (it.state == LoanState.REJECTED) {
                sheetLoanBinding.state.text = getString(R.string.stateString, it.state.toString())
                sheetLoanBinding.state.setTextColor(Color.parseColor("#FF2800"))

            } else if (it.state == LoanState.APPROVED) {
                sheetLoanBinding.state.text = getString(R.string.stateString, it.state.toString())
                sheetLoanBinding.state.setTextColor(Color.parseColor("#00A600"))
            }

            sheetLoanBinding.lastName.text = getString(R.string.lastNameString, it.lastName)
            sheetLoanBinding.firstName.text = getString(R.string.firstNameString, it.firstName)
            sheetLoanBinding.amount.text = getString(R.string.amountString, it.amount.toString())

            val date = formatDate(it.date)
            sheetLoanBinding.date.text = getString(R.string.date, date)
            sheetLoanBinding.percent.text = getString(R.string.percentString, it.percent.toString())
            sheetLoanBinding.period.text = getString(R.string.periodString, it.period.toString())
            sheetLoanBinding.phoneNumber.text =
                getString(R.string.phoneNumberString, it.phoneNumber)
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