package com.example.jikgong.view.main.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 알림 테스트 용, intent 또는 fragment로 교체 예정
        binding.buttonNotification.setOnClickListener {
            var builder = AlertDialog.Builder(this.activity)
            builder.setTitle("알림")
            builder.setMessage("알림입니다요오")

            builder.setNegativeButton("취소") {dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        binding.welcomeText.text = "직공기업, 환영합니다"

        return root
    }

}