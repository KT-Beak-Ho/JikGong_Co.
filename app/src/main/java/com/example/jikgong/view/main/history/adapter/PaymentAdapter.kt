package com.example.jikgong.view.main.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jikgong.R
import com.example.jikgong.view.main.history.dataModel.PaymentItem

//  recyclerView에 데이터 연동
class PaymentAdapter(val paymentList: ArrayList<PaymentItem>) :
    RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    // Define a callback interface for the button click
    interface PaymentItemClickListener {
        fun onDepositButtonClick(position: Int)
    }

    // Listener to handle button click events
    private var itemClickListener: PaymentItemClickListener? = null

    // Method to set the item click listener
    fun setItemClickListener(listener: PaymentItemClickListener) {
        itemClickListener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerTitleTextView: TextView = itemView.findViewById(R.id.payments_48h_body_item_header_title)
        val headerJobNameTextView: TextView = itemView.findViewById(R.id.payments_48h_body_item_header_job_name_content)
        val bodyTotalPayment: TextView = itemView.findViewById(R.id.payments_48h_body_item_body_total_payment)
        val bodyPaymentLimitDate:TextView = itemView.findViewById(R.id.payments_48h_body_item_body_payment_limit_date)
        val depositButton: Button = itemView.findViewById(R.id.payments_48h_body_item_body_total_payment_button)

        init {
            // Set up click listener for the button
            depositButton.setOnClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Notify the listener about the button click
                    itemClickListener?.onDepositButtonClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payments_48h_body, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.headerTitleTextView.text = paymentList[position].headerTitle
        holder.headerJobNameTextView.text = paymentList[position].headerJobName
        holder.bodyTotalPayment.text = paymentList[position].bodyTotal
        holder.bodyPaymentLimitDate.text = paymentList[position].bodyPayment
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }
}