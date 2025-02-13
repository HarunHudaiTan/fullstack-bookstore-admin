package com.project.bookstore.dto

import com.project.bookstore.model.Orders
import com.project.bookstore.model.PaymentMethod
import com.project.bookstore.model.TransactionStatus
import com.project.bookstore.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    val amount:BigDecimal?,
    val transactionDate: LocalDateTime?,
    val transactionType: TransactionType?,
    val transactionStatus: TransactionStatus?,
    val paymentMethod: PaymentMethod?,
    val order:Orders,

    ) {
}