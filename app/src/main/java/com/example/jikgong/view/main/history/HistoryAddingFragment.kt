package com.example.jikgong.view.main.history

import android.R
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jikgong.databinding.FragmentHistoryAddingBinding


class HistoryAddingFragment : Fragment() {

    private var _binding: FragmentHistoryAddingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryAddingBinding.inflate(inflater, container, false)
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.paymentsAddPageBodyJobDateTitleCalendarButton.setOnClickListener {
            val fragment = HistoryAddingBottomSheetDialogFragment()
            fragment.show(requireActivity().supportFragmentManager, "HistoryAddingBottomSheet")
        }

        return binding.root
    }

    private fun paymentsAddPageBodyFieldTitle(){
        val textView: TextView = binding.paymentsAddPageBodyFieldTitle
        val text = binding.paymentsAddPageBodyFieldTitle.text

        val spannableString = SpannableString(text)

        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#02030C")),
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#3971FF")),
            4,
            5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val alphaValue = (255 * 0.36).toInt() // Calculate alpha value for 36% transparency
        val transparentColor = Color.argb(alphaValue, 2, 3, 12)
        spannableString.setSpan(
            ForegroundColorSpan(transparentColor),
            6,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.text = spannableString
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paymentsAddPageBodyFieldTitle()
//        // Print the name of the current fragment
//        val currentDestinationId = findNavController().currentDestination?.id
//        val fragmentName = currentDestinationId?.let { resources.getResourceEntryName(it) }
//        Log.d("CurrentFragment", "Current Fragment: $fragmentName")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

//    fun onDirectAddButtonClick(view: View) {
//        // FragmentTransaction 시작
//        val transaction = requireActivity().supportFragmentManager.beginTransaction()
//
//        // 새로운 프래그먼트 생성
//        val addingFragment = _HistoryAddingFragment()
//
//        // 프래그먼트 전환
//        transaction.replace(R.id.payments_main, addingFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

}