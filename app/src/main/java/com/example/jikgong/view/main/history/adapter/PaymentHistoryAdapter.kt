package com.example.jikgong.view.main.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jikgong.R
import com.example.jikgong.view.main.history.dataModel.PaymentHistoryItem

class PaymentHistoryAdapter(val paymentHistoryList: List<PaymentHistoryItem>) :
    RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerTitleTextView: TextView = itemView.findViewById(R.id.payments_history_body_item_header_title)
        val bodyContentsTextView: TextView = itemView.findViewById(R.id.payments_history_body_item_body_contents)
        val workerCount: TextView = itemView.findViewById(R.id.payments_history_body_item_footer_worker_count)
        val date: TextView = itemView.findViewById(R.id.payments_history_body_item_footer_date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payments_history_body, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.headerTitleTextView.text = paymentHistoryList[position].headerTitle
        holder.bodyContentsTextView.text = paymentHistoryList[position].bodyContents
        holder.workerCount.text = paymentHistoryList[position].workerCount
        holder.date.text = paymentHistoryList[position].date
    }

    override fun getItemCount(): Int {
        return paymentHistoryList.size
    }
}