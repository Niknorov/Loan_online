package com.example.loan_online.features.loans.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loan_online.R
import com.example.loan_online.databinding.RecyclerviewItemBinding
import com.example.loan_online.features.create.domain.LoanModel
import com.example.loan_online.features.create.domain.LoanState

class LoansRecyclerAdapter(private val loans: List<LoanModel>) :
    RecyclerView.Adapter<LoansRecyclerAdapter.LoanViewHolder>() {

    var onItemClick: ((LoanModel) -> Unit)? = null

    inner class LoanViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loanModel: LoanModel) {

            binding.date.text = loanModel.date
            if (loanModel.state == LoanState.REGISTERED) {
                binding.state.text = loanModel.state.toString()
                binding.state.setTextColor(Color.parseColor("#FCD12A"))

            } else if (loanModel.state == LoanState.REJECTED) {
                binding.state.text = loanModel.state.toString()
                binding.state.setTextColor(Color.parseColor("#FF2800"))

            } else if (loanModel.state == LoanState.APPROVED) {
                binding.state.text = loanModel.state.toString()
                binding.state.setTextColor(Color.parseColor("#00A600"))
            }
            binding.amount.text = loanModel.amount.toString()

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
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(loans[position])
        }

    }

    override fun getItemCount() = loans.size

}