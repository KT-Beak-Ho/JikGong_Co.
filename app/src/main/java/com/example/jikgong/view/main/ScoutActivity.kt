package com.example.jikgong.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.jikgong.R
import com.example.jikgong.view.main.scout.ScoutFragment


class ScoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 초기 프래그먼트 설정
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.toolbar, ScoutFragment())
                .commit()
        }
    }
}