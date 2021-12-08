package com.example.loan_online.features.create.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loan_online.R
import com.example.loan_online.databinding.FragmentCreateLoanBinding
import com.example.loan_online.databinding.SheetLoanBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class CreateLoanFragment : Fragment() {
    private lateinit var sheetLoanBinding: SheetLoanBinding
    private lateinit var binding: FragmentCreateLoanBinding
    private val viewModel: CreationViewModel by viewModel()

    private fun hideError() {
        if (binding.firstName.editText?.text?.isNotBlank() == true) {
            binding.firstName.error = ""
            binding.createButton.isClickable = true
        }
        if (binding.lastName.editText?.text?.isNotBlank() == true) {
            binding.lastName.error = ""
            binding.createButton.isClickable = true
        }
        if (binding.amount.editText?.text?.isNotBlank() == true) {
            binding.amount.error = ""
            binding.createButton.isClickable = true
        }
        if (binding.phoneNumber.editText?.text?.isNotBlank() == true) {
            binding.phoneNumber.error = ""
            binding.createButton.isClickable = true
        }
    }

    private fun requestLoan() {
        if (binding.firstName.editText?.text?.isBlank() == true) {
            binding.firstName.error = "Введите имя"
            binding.createButton.isClickable = false
        } else if (binding.lastName.editText?.text?.isBlank() == true) {
            binding.lastName.error = "Введите фамилию"
            binding.createButton.isClickable = false
        } else if (binding.amount.editText?.text?.isBlank() == true) {
            binding.amount.error = "Введите сумму"
            binding.createButton.isClickable = false
        } else if (binding.phoneNumber.editText?.text?.isBlank() == true) {
            binding.phoneNumber.error = "Введите номер телефона"
            binding.createButton.isClickable = false
        } else {


            viewModel.getLoan(

                amount = binding.amount.editText?.text.toString().toDouble(),
                firstName = binding.firstName.editText?.text.toString(),
                lastName = binding.lastName.editText?.text.toString(),
                phoneNumber = binding.phoneNumber.editText?.text.toString()
            )
            binding.createButton.isEnabled = false

        }
    }

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

        binding.createButton.setOnClickListener {

            requestLoan()

        }

        binding.firstName.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?, start: Int, before: Int, count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {
                hideError()
            }
        })

        binding.lastName.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?, start: Int, before: Int, count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {
                hideError()
            }
        })
        binding.amount.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?, start: Int, before: Int, count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {
                hideError()
                if (binding.amount.editText?.text?.isNotBlank() == true && binding.amount.editText?.text?.toString()
                        ?.toDouble()!! > viewModel.conditionsLiveData.value?.maxAmount!!
                ) {
                    binding.amount.error = "Сумма не должна превышать допустимую"
                }

            }
        })
        binding.phoneNumber.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?, start: Int, before: Int, count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {
                hideError()
            }
        })


        viewModel.loanLiveData.observe(
            viewLifecycleOwner
        )
        {
            sheetLoanBinding = SheetLoanBinding.inflate(layoutInflater)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(sheetLoanBinding.root)
            dialog.show()
            sheetLoanBinding.state.text = it.state.toString()
            sheetLoanBinding.lastName.text = it.lastName
            sheetLoanBinding.firstName.text = it.firstName
            sheetLoanBinding.amount.text = it.amount.toString()
            sheetLoanBinding.date.text = it.date
            sheetLoanBinding.percent.text = it.percent.toString()
            sheetLoanBinding.period.text = it.period.toString()
            sheetLoanBinding.phoneNumber.text = it.phoneNumber
        }


    }

}
