package com.example.jikgong.view.main.scout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.jikgong.R

class ScoutListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_scout_list, container, false)

        // someOtherLayout을 초기화. 이 예시에서는 fragment_main.xml에 있는 레이아웃을 사용
        val someOtherLayout = view.findViewById<LinearLayout>(R.id.some_layout)

        val myLayout = inflater.inflate(R.layout.item_scout_info, null)

        myLayout.setOnClickListener {
            // 레이아웃이 클릭되었을 때 실행할 코드를 여기에 작성
            val transaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, ScoutHumanInfoFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // someOtherLayout에 myLayout 추가
        someOtherLayout.addView(myLayout)

        return view
    }

}