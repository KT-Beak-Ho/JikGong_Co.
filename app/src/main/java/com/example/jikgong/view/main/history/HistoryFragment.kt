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

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}