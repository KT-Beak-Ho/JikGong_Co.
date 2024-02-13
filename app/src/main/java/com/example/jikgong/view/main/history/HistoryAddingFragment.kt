package com.example.jikgong.view.main.history

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.jikgong.databinding.FragmentHistoryAddingBinding
import com.example.jikgong.databinding.FragmentHistoryBinding

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
        binding.backButton.setOnClickListener{
            findNavController().navigateUp()
        }

//        val editTextInput: EditText = binding.paymentsAddPageBodyFieldInput
//        val buttonSubmit: Button = binding.paymentsAddPageSubmitButton
//
//        buttonSubmit.setOnClickListener {
//            // EditText에서 입력된 문자열 가져오기
//            val userInput = editTextInput.text.toString()
//
//            // 입력된 문자열을 Toast 메시지로 표시
//            showToast(userInput)
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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