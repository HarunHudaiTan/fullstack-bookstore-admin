package com.project.bookstore.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Orders(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val orderDate: LocalDateTime,
    val totalPrice: BigDecimal?,
    @OneToOne(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    val transaction: Transaction,
    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
    @OneToMany(mappedBy = "order", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val orderItems: Set<OrderItem>?,

    @ManyToOne(fetch = FetchType.LAZY)
    val user: User

)

enum class OrderStatus {
    PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}
