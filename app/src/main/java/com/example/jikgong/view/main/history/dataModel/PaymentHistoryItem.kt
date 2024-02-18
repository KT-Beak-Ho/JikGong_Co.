package com.example.jikgong.view.main.history.dataModel

//  데이터 객체 형식
data class PaymentHistoryItem(
    val headerTitle: String,
    val bodyContents: String,
    val workerCount: String,
    val date: String,
    val isRead:Boolean
)