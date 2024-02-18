package com.example.jikgong.view.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentHistoryMainBinding
import com.example.jikgong.view.main.history.adapter.PaymentAdapter
import com.example.jikgong.view.main.history.adapter.PaymentHistoryAdapter
import com.example.jikgong.view.main.history.dataModel.PaymentHistoryItem
import com.example.jikgong.view.main.history.dataModel.PaymentItem
import com.example.jikgong.view.main.history.dataSet.PaymentHistoryDataGen


class HistoryMainFragment : Fragment() {
    private var _binding: FragmentHistoryMainBinding? = null
    private val binding get() = _binding!!

    //  RecyclerView 데이터 연동
    private lateinit var paymentAdapter: PaymentAdapter
    private lateinit var paymentHistoryAdapter: PaymentHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Ensure current fragment is displayed
//        findNavController().popBackStack(R.id.historyMainFragment, false)
//
//        // Print the name of the current fragment
//        val currentDestinationId = findNavController().currentDestination?.id
//        val fragmentName = currentDestinationId?.let { resources.getResourceEntryName(it) }
//        Log.d("CurrentFragment", "Current Fragment: $fragmentName")
//
//        if (fragmentName != "historyMainFragment") {
//            findNavController().navigate(R.id.historyMainFragment)
//            return
//        }
        //  지급관리 - 직접 추가하기 버튼 클릭
        binding.paymentsTotalAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_historyMainFragment_to_historyAddingFragment)
        }
        //  지급내역서 - 더보기 버튼 클릭
        binding.paymentsHistoryShowMoreButton.setOnClickListener {
            findNavController().navigate(R.id.action_historyMainFragment_to_paymentsHistoryShowMoreFragment)
        }

        //  48H 시간 이내 입금 관련
        val rcFortyEightHour = binding.recyclerViewPayments
        rcFortyEightHour.layoutManager = LinearLayoutManager(requireContext())
        val paymentItems = ArrayList<PaymentItem>()
        paymentItems.add(
            PaymentItem(
                "1월 25일 출역",
                "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사",
                "1,000,000원",
                "1월 25일 오전 06:30 까지 입금"
            )
        )
        paymentItems.add(
            PaymentItem(
                "1월 24일 출역",
                "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사",
                "200,000원",
                "1월 24일 오전 06:30 까지 입금"
            )
        )

        paymentAdapter = PaymentAdapter(paymentItems)
        rcFortyEightHour.adapter = paymentAdapter

        paymentAdapter.setItemClickListener(object : PaymentAdapter.PaymentItemClickListener {
            override fun onDepositButtonClick(position: Int) {
                // Handle the button click for the specific item
                showToast("입금 버튼이 클릭되었습니다. Position: $position")
            }
        })
        //  RecyclerView 화면 결정
        updateUI1(paymentItems)

//          지급내역서 관련
        val rePaymentHistory = binding.recyclerViewPaymentsHistory
        rePaymentHistory.layoutManager = LinearLayoutManager(requireContext())

        var paymentHistoryItems =  PaymentHistoryDataGen.generateSamplePaymentHistoryItems()
        paymentHistoryAdapter = PaymentHistoryAdapter(paymentHistoryItems)
        rePaymentHistory.adapter = paymentHistoryAdapter

        //  RecyclerView 화면 결정
        updateUI2(paymentHistoryItems)

    }

    //  RecyclerView1 화면 결정
    private fun updateUI1(paymentItems: List<PaymentItem>) {
        val recyclerView = binding.recyclerViewPayments
        val emptyView = binding.payments48hBodyEmpty

        if (paymentItems.isEmpty()) {
            // No data, show empty view
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            // Data is available, show RecyclerView
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
            paymentAdapter.notifyDataSetChanged()
        }
    }

    //  RecyclerView2 화면 결정
    private fun updateUI2(paymentHistoryItems: List<PaymentHistoryItem>) {
        val recyclerView = binding.recyclerViewPaymentsHistory
        val emptyView = binding.paymentsHistoryBodyEmpty
        val detailButton = binding.paymentsHistoryShowMoreButton

        if (paymentHistoryItems.isEmpty()) {
            // No data, show empty view
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
            detailButton.visibility = View.GONE
        } else {
            // Data is available, show RecyclerView
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
            detailButton.visibility = View.VISIBLE
            paymentHistoryAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}