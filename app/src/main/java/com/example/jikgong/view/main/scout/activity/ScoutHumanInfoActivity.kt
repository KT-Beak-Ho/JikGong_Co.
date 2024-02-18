package com.example.jikgong.view.main.scout.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jikgong.R
import com.example.jikgong.databinding.ActivityMainBinding
import com.example.jikgong.view.main.scout.adapter.HumanInfoAdapter
import com.example.jikgong.view.main.scout.dataModel.HumanInfoItem

class ScoutHumanInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = arrayOf(HumanInfoItem(R.drawable.ic_profil, "홍길동", "만 30세 · 남 · 경력 5년", "부산시 사하구 하단동", 3, 80, "9:00~21:00" ))

        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView.adapter = HumanInfoAdapter(myDataset)
    }
}