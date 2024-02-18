package com.example.jikgong.view.main.history.dataSet

import com.example.jikgong.view.main.history.dataModel.PaymentHistoryItem

object  PaymentHistoryDataGen {
    fun generateSamplePaymentHistoryItems(): List<PaymentHistoryItem> {
        val paymentHistoryItems = mutableListOf<PaymentHistoryItem>()

        // Add sample payment history items
        paymentHistoryItems.add(
            PaymentHistoryItem(
                "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사",
                "1월 25일 보통인부 지급내역서",
                "보통인부 10명",
                "2024.01.23",
                isRead = false
            )
        )
//        paymentHistoryItems.add(
//            PaymentHistoryItem(
//                "사하구 낙동5블럭 낙동강 온도 측정 센터 신축 공사",
//                "1월 25일 보통인부 지급내역서",
//                "보통인부 10명",
//                "2024.01.23",
//                isRead = true
//            )
//        )

        // Add more sample payment history items as needed

        return paymentHistoryItems
    }
}