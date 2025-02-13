package com.project.bookstore.model

import jakarta.persistence.*
import jakarta.persistence.criteria.Order
import java.math.BigDecimal

@Entity
data class OrderItem (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val quantity : Int?,
    val price : BigDecimal?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    val books:Book?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Orders?

)
