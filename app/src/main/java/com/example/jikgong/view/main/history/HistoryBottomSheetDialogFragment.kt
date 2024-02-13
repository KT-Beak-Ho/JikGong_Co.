package com.example.jikgong.view.main.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jikgong.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryBottomSheetDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history_bottom_sheet_dialog, container, false)
    }
}
