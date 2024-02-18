package com.example.jikgong.view.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentHistoryAddingBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryAddingBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentHistoryAddingBottomSheetDialogBinding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryAddingBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButtonBtn.setOnClickListener {
            dismiss()
        }
    }
}