package com.example.jikgong.view.main.history

import android.content.Intent
import com.example.jikgong.view.main.history.adapter.PaymentAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentHistoryAddingBinding
import com.example.jikgong.databinding.FragmentHistoryBinding
import com.example.jikgong.view.main.history.adapter.PaymentHistoryAdapter
import com.example.jikgong.view.main.history.dataModel.PaymentHistoryItem
import com.example.jikgong.view.main.history.dataModel.PaymentItem

class HistoryFragment : Fragment() {


    //  RecyclerView 데이터 연동
//    private lateinit var paymentAdapter: PaymentAdapter
//    private lateinit var paymentHistoryAdapter: PaymentHistoryAdapter

    private var _binding:FragmentHistoryBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
//        val toolbar: Toolbar = binding.toolbar
//        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
//        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
//            title = "Fragment Title" // Set the title
//            setDisplayHomeAsUpEnabled(true) // Show the back button
//        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        //  48H 시간 이내 입금 관련
//        val recyclerView1 = binding.recyclerViewPayments
//        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
//
//        val paymentItems = ArrayList<PaymentItem>()
//        paymentItems.add(PaymentItem("1월 25일 출역", "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사", "1,000,000원", "1월 25일 오전 06:30 까지 입금"))
//        paymentItems.add(PaymentItem("1월 24일 출역", "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사", "200,000원", "1월 24일 오전 06:30 까지 입금"))
//
//        paymentAdapter = PaymentAdapter(paymentItems)
//        recyclerView1.adapter = paymentAdapter
//
//        paymentAdapter.setItemClickListener(object : PaymentAdapter.PaymentItemClickListener {
//            override fun onDepositButtonClick(position: Int) {
//                // Handle the button click for the specific item
//                showToast("입금 버튼이 클릭되었습니다. Position: $position")
//            }
//        })
//
//
//        //  RecyclerView 화면 결정
//        updateUI1(paymentItems)
//
//        //  지급내역서 관련
//        val recyclerView2 = binding.recyclerViewPaymentsHistory
//        recyclerView2.layoutManager = LinearLayoutManager(requireContext())
//
//        var paymentHistoryItems = ArrayList<PaymentHistoryItem>()
//        paymentHistoryItems.add(PaymentHistoryItem("사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사", "1월 25일 보통인부 지급내역서", "보통인부 10명", "2024.01.23"))
//        paymentHistoryItems.add(PaymentHistoryItem("사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사", "1월 25일 보통인부 지급내역서", "보통인부 10명", "2024.01.23"))
//
//        paymentHistoryAdapter = PaymentHistoryAdapter(paymentHistoryItems)
//        recyclerView2.adapter = paymentHistoryAdapter
//
////        paymentHistoryAdapter.setItemClickListener(object : PaymentAdapter.PaymentItemClickListener {
////            override fun onDepositButtonClick(position: Int) {
////                // Handle the button click for the specific item
////                showToast("입금 버튼이 클릭되었습니다. Position: $position")
////            }
////        })
//        //  RecyclerView 화면 결정
//        updateUI2(paymentHistoryItems)
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentHistoryBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        //  지급 총액 - 직접 추가 하기 버튼
//        binding.paymentsTotalAddButton.setOnClickListener {
//            showToast("직접 추가하기 버튼이 클릭되었습니다.")
//            val intent = Intent(requireContext(), HistoryAddingFragment::class.java)
//            startActivity(intent)
//        }
//
//        //  지급 내역서 - 더보기 버튼
//        binding.paymentsHistoryShowMoreButton.setOnClickListener{
//            showToast("지급 내역서 - 더보기 버튼이 클릭되었습니다.")
//        }
//
//        //  48시간 이내 입금 - 더보기 버튼
//
////        showBottomSheetDialogFragment()
//        return root
//    }
//
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
//
//    //  RecyclerView1 화면 결정
//    private fun updateUI1(paymentItems: List<PaymentItem>) {
//        val recyclerView = binding.recyclerViewPayments
//        val emptyView = binding.payments48hBodyEmpty
//
//        if (paymentItems.isEmpty()) {
//            // No data, show empty view
//            recyclerView.visibility = View.GONE
//            emptyView.visibility = View.VISIBLE
//        } else {
//            // Data is available, show RecyclerView
//            recyclerView.visibility = View.VISIBLE
//            emptyView.visibility = View.GONE
//            paymentAdapter.notifyDataSetChanged()
//        }
//    }
//
//    //  RecyclerView2 화면 결정
//    private fun updateUI2(paymentHistoryItems: List<PaymentHistoryItem>) {
//        val recyclerView = binding.recyclerViewPaymentsHistory
//        val emptyView = binding.paymentsHistoryBodyEmpty
//
//        if (paymentHistoryItems.isEmpty()) {
//            // No data, show empty view
//            recyclerView.visibility = View.GONE
//            emptyView.visibility = View.VISIBLE
//        } else {
//            // Data is available, show RecyclerView
//            recyclerView.visibility = View.VISIBLE
//            emptyView.visibility = View.GONE
//            paymentHistoryAdapter.notifyDataSetChanged()
//        }
//    }
}