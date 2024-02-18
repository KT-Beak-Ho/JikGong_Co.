//  지급내역서
package com.example.jikgong.view.main.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentPaymentsHistoryShowMoreBinding
import com.example.jikgong.view.main.history.adapter.PaymentHistoryAdapter
import com.example.jikgong.view.main.history.dataModel.PaymentHistoryItem
import com.example.jikgong.view.main.history.dataModel.PaymentItem
import com.example.jikgong.view.main.history.dataSet.PaymentHistoryDataGen


class PaymentsHistoryShowMoreFragment : Fragment() {

    private var _binding: FragmentPaymentsHistoryShowMoreBinding? = null
    private val binding get() = _binding!!

    private lateinit var paymentHistoryAdapter: PaymentHistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentsHistoryShowMoreBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        //  전체 보기 버튼
        val showAllBTN =binding.paymentsHistoryShowPageBodySummaryShowOptionAll
        //  안읽음 버튼
        val showNotReadBTN = binding.paymentsHistoryShowPageBodySummaryShowOptionNotRead

        showAllBTN.setOnClickListener{
            showNotReadBTN.setTextColor(ContextCompat.getColor(requireContext(), R.color.Black))
            showAllBTN.setTextColor(ContextCompat.getColor(requireContext(), R.color.Secondary_B))

        }
        showNotReadBTN.setOnClickListener{
            showAllBTN.setTextColor(ContextCompat.getColor(requireContext(), R.color.Black))
            showNotReadBTN.setTextColor(ContextCompat.getColor(requireContext(), R.color.Secondary_B))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var paymentHistoryItems =  PaymentHistoryDataGen.generateSamplePaymentHistoryItems()
        paymentHistoryAdapter = PaymentHistoryAdapter(paymentHistoryItems)

        updateUI1(paymentHistoryItems)
    }
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun updateUI1(paymentItems: List<PaymentHistoryItem>) {
        val recyclerView = binding.recyclerViewPaymentsHistory
        val emptyView = binding.paymentsHistoryBodyEmpty
        Log.d("PaymentItemsSize", "PaymentItems size: ${paymentItems.size}")
        if (paymentItems.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            // Data is available, show RecyclerView
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
            paymentHistoryAdapter.notifyDataSetChanged()
        }
    }
}