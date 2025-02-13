package com.project.bookstore.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?,
//    @ManyToOne(fetch = FetchType.LAZY)
//    val account: Account,
    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType,
    @Enumerated(EnumType.STRING)
    val status: TransactionStatus,
    @Enumerated(EnumType.STRING)
    val paymentMethod: PaymentMethod,
    @OneToOne(fetch = FetchType.EAGER)
    val order:Orders
)

enum class TransactionType {
    PURCHASE,REFUND
}
enum class TransactionStatus {
    PENDING,COMPLETED,FAILED,CANCELED
}
enum class PaymentMethod{
    CREDIT_CARD,PAYPAL,E_WALLET
}