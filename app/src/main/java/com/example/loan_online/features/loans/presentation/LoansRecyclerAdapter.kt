package com.example.loan_online.features.loans.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loan_online.databinding.RecyclerviewItemBinding
import com.example.loan_online.features.create.domain.LoanModel

class LoansRecyclerAdapter(private val loans: List<LoanModel>) :
    RecyclerView.Adapter<LoansRecyclerAdapter.LoanViewHolder>() {


    inner class LoanViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loanModel: LoanModel) {

            binding.date.text = loanModel.date
            binding.amount.text = loanModel.amount.toString()
            binding.state.text = loanModel.state.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {

        val binding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LoanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {

        val loanModel: LoanModel = loans[position]
        holder.bind(loanModel)

    }

    override fun getItemCount() = loans.size

}